package com.example.vaccinatetogether.security;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.vaccinatetogether.exception.JwtException;



@Component
public class JwtFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		
		if(header == null || !header.startsWith("Bearer ")) {
			throw new JwtException("Invalid header");
		}
		String token = header.substring(7);
		String username = jwtUtil.parseTokenUsername(token);
		UserDetails userDetail = userDetailsService.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken upat = 
				new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
		upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		SecurityContextHolder.getContext().setAuthentication(upat);
		
		filterChain.doFilter(request, response);
	}
	
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        boolean doNotFilter = false;
        if(path.startsWith("/login") 
        		|| path.startsWith("/register") 
        		|| path.startsWith("/operator/register") 
        		|| path.startsWith("/operator/login")) {
        	doNotFilter = true;
        }
        return doNotFilter;
    }
	
	
}