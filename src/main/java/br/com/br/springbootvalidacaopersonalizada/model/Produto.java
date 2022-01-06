package br.com.br.springbootvalidacaopersonalizada.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = {"nome", "preco", "categorias"})
public class Produto implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private BigDecimal preco;

    public Produto(Integer id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA",
               joinColumns = @JoinColumn(name = "produto_id"),
               inverseJoinColumns = @JoinColumn(name = "categoria_id"))

    private List<Categoria> categorias = new ArrayList<>();
}
