package com.melcam.customerservice.controller;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Data
@Setter
@Builder
public class ErrorMessage {
  private String code;
  private List<Map<String, String>> message;
}
