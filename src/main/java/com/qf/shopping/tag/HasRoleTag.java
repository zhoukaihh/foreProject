// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   HasRoleTag.java

package com.qf.shopping.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HasRoleTag extends SimpleTagSupport
{

	private String role;
	private String token;

	public HasRoleTag()
	{
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public void doTag()
		throws JspException, IOException
	{
		if (token.equals("admin"))
			getJspBody().invoke(null);
	}
}
