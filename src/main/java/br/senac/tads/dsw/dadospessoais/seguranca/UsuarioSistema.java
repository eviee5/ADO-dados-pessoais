package br.senac.tads.dsw.dadospessoais.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioSistema implements UserDetails{
    private final String username;
    private final String password;
    private final List<GrantedAuthority>authorities;

    public UsuarioSistema(String username, String password, List<GrantedAuthority>autorities){
            this.username=username;
            this.password=password;
            this.authorities=autorities;
    }
    @Override
    public String getUsername() { return username; }

    @Override
    public String getPassword() { return password; }
    // getAuthorities() retorna a lista de permissões (roles) do usuario.
    // GrantedAuthority é uma interface, SimpleGrantedAuthority é a implementação padrão.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return authorities; }

    // Os quatro métodos abaixo controlamo estado da conta.
    // Retornam true por simplicidade em produção você implementaría lógica de bloqueio,
    // expiração de senha, etc., consultando um banco de dados.
    @Override public boolean isAccountNonExpired() {return true; }
    @Override public boolean isAccountNonLocked() {return true; }
    @Override public boolean isCredentialsNonExpired() {return true; }
    @Override public boolean isEnabled() {return true; }
}
