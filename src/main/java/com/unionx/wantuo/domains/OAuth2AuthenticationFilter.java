package com.unionx.wantuo.domains;
import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;
public class OAuth2AuthenticationFilter extends AuthenticatingFilter {
	// oauth2 authc code
	private String authcCodeParam = "code";
	private String clientId;
	private String redirectUrl;
	private String responseType = "code";
	private String failureUrl;
	public void setAuthcCodeParam(String authcCodeParam) {
		this.authcCodeParam = authcCodeParam;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
	
	public String getAuthcCodeParam() {
		return authcCodeParam;
	}
	public String getClientId() {
		return clientId;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public String getResponseType() {
		return responseType;
	}
	public String getFailureUrl() {
		return failureUrl;
	}
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String code = httpRequest.getParameter(authcCodeParam);
		return new OAuth2Token(code);
	}
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		return false;
	}
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		String error = request.getParameter("error");
		String errorDescription = request.getParameter("error_description");
		if (!StringUtils.isEmpty(error)) {// ������˷����˴���
			WebUtils.issueRedirect(request, response,
					failureUrl + "?error=" + error + "error_description=" + errorDescription);
			return false;
		}
		Subject subject = getSubject(request, response);
		if (!subject.isAuthenticated()) {
			if (StringUtils.isEmpty(request.getParameter(authcCodeParam))) {
				// ����û�û�������֤����û��auth code�����ض��򵽷������Ȩ
				saveRequestAndRedirectToLogin(request, response);
				return false;
			}
		}
		return executeLogin(request, response);
	}
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		issueSuccessRedirect(request, response);
		return false;
	}
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException ae, ServletRequest request,
			ServletResponse response) {
		Subject subject = getSubject(request, response);
		if (subject.isAuthenticated() || subject.isRemembered()) {
			try {
				issueSuccessRedirect(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				WebUtils.issueRedirect(request, response, failureUrl);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}