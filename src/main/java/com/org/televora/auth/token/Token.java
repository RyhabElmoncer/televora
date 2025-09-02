package com.org.televora.auth.token;

import com.org.televora.auth.Model.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tokens")
public class Token {

  @Id
  @GeneratedValue
  private UUID id;
  @Column(length = 10000, unique = true, nullable = false)
  private String token;



  @Enumerated(EnumType.STRING)
  private TokenType tokenType = TokenType.BEARER;

  private boolean revoked;
  private boolean expired;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;
}
