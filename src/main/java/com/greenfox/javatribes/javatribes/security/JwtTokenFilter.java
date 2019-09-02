package com.greenfox.javatribes.javatribes.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenfox.javatribes.javatribes.dto.ResponseObject;
import com.greenfox.javatribes.javatribes.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// We should use OncePerRequestFilter since we are doing a database call, there is no point in doing this more than once
public class JwtTokenFilter extends OncePerRequestFilter {

  private JwtTokenProvider jwtTokenProvider;

  public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
    this.jwtTokenProvider = jwtTokenProvider;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                  FilterChain filterChain) throws ServletException, IOException {

    try {
      String token = jwtTokenProvider.resolveToken(httpServletRequest);
      if (token != null && jwtTokenProvider.validateToken(token)) {
        Authentication auth = jwtTokenProvider.getAuthentication(token);
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (CustomException ex) {
      //this is very important, since it guarantees the user is not authenticated at all
      SecurityContextHolder.clearContext();

      httpServletResponse.setContentType("application/json");
      httpServletResponse.setStatus(ex.getHttpStatus().value());
      ObjectMapper objectMapper = new ObjectMapper();
      ResponseObject responseObject = new ResponseObject("error", ex.getMessage());
      httpServletResponse.getOutputStream().println(objectMapper.writeValueAsString(responseObject));
      return;
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
