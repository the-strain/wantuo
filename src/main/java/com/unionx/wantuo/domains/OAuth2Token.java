package com.unionx.wantuo.domains;
import org.apache.shiro.authc.AuthenticationToken;
@SuppressWarnings("serial")
public class OAuth2Token implements AuthenticationToken {
	    public OAuth2Token(String authCode) {
	        this.authCode = authCode;
	    }
	    private String authCode;
	    private String principal;
	    public String getAuthCode() {
	        return authCode;
	    }
	    public void setAuthCode(String authCode) {
	        this.authCode = authCode;
	    }
	    public String getPrincipal() {
	        return principal;
	    }
	    public void setPrincipal(String principal) {
	        this.principal = principal;
	    }
	    @Override
	    public Object getCredentials() {
	        return authCode;
	    }
	}
