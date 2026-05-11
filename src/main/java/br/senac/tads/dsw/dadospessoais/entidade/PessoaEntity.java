package br.senac.tads.dsw.dadospessoais.entidade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // Marca esta classe como uma entidade JPA
 // (será uma tabela no banco)

@Table(name = "tb_pessoas") // Define o nome da tabela

public class PessoaEntity {

 
 @Id // Chave primária
 // Anotação abaixo faz banco gerar o ID automaticamente (autoincrement)
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @Column(nullable = false, unique = true, length = 64) // Coluna NOT NULL, UNIQUE,
 // VARCHAR(64)
 private String username;

 @Column(nullable = false, length = 100)
 private String nome;

 @Column(nullable = false, length = 100)
 private String email;

 @Column(name = "data_nascimento") // Nome da coluna no banco
 private LocalDate dataNascimento;

 @Column(length = 255)
 private String senha;
 // Relacionamento: uma pessoa pode ter vários conhecimentos,
 // e o mesmo conhecimento pode ser associado a várias pessoas.

 // @JoinTable → define a tabela de junção que une as duas entidades

// CascadeType.ALL → operações (salvar, deletar) propagam automaticamente para
 // os conhecimentos

 // FetchType.EAGER → os conhecimentos são carregados junto com a pessoa (simplifica
 // o uso)
 @ManyToMany(
    cascade = CascadeType.ALL,
    fetch = FetchType.EAGER
    )
    @JoinTable(
    name = "tb_pessoas_conhecimentos", // (1)
    joinColumns = @JoinColumn(name = "pessoa_id"), // (2)
    inverseJoinColumns = @JoinColumn(name = "conhecimento_id") // (3)
    )
    private Set<ConhecimentoEntity> conhecimentos = new HashSet<>();
    // (1) nome da tabela de junção
    // (2) FK que aponta para tb_pessoas
    // (3) FK que aponta para tb_conhecimentos


 public Long getId() {
    return id;
 }

 public void setId(Long id) {
    this.id = id;
 }

 public String getUsername() {
    return username;
 }

 public void setUsername(String username) {
    this.username = username;
 }

 public String getNome() {
    return nome;
 }

 public void setNome(String nome) {
    this.nome = nome;
 }

 public String getEmail() {
    return email;
 }

 public void setEmail(String email) {
    this.email = email;
 }

 public LocalDate getDataNascimento() {
    return dataNascimento;
 }

 public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
 }

 public String getSenha() {
    return senha;
 }

 public void setSenha(String senha) {
    this.senha = senha;
 }

 public Set<ConhecimentoEntity> getConhecimentos() {
    return conhecimentos;
 }

 public void setConhecimentos(Set<ConhecimentoEntity> conhecimentos) {
    this.conhecimentos = conhecimentos;
 }

    public PessoaEntity(){

    }
   }