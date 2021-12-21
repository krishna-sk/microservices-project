package com.krishna.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@RefreshScope
public class TestController {

	@Value("${secret_key}")
	private String secret_key;

  @GetMapping("/test")
  public String propertyFromHashiCorpVault() {
    return secret_key;
  }
}
