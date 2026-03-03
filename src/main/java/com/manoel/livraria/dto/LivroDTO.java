    package com.manoel.livraria.dto;

    import com.manoel.livraria.entities.Livro;

    import java.time.Instant;

    public class LivroDTO {

        private Long id;
        private String autor;
        private String titulo;
        private Instant dataCadastro;
        private Integer anoPublicacao;

        public LivroDTO(Long id, String autor, String titulo, Instant dataCadastro, Integer anoPublicacao) {
            this.id = id;
            this.autor = autor;
            this.titulo = titulo;
            this.dataCadastro = dataCadastro;
            this.anoPublicacao = anoPublicacao;
        }
        public LivroDTO(Livro entity) {
            id = entity.getId();
            autor = entity.getAutor();
            titulo = entity.getTitulo();
            dataCadastro = entity.getDataCadastro();
            anoPublicacao = entity.getAnoPublicacao();
        }


        public LivroDTO(){}

        public Long getId() {
            return id;
        }

        public String getAutor() {
            return autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public Instant getDataCadastro() {
            return dataCadastro;
        }

        public Integer getAnoPublicacao() {
            return anoPublicacao;
        }

    }
