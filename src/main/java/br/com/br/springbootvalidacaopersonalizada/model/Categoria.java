package br.com.br.springbootvalidacaopersonalizada.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Data 
@NoArgsConstructor
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = {"nome", "produtos"})
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    private String nome;

    public Categoria(Integer id, String nome) {
        super();
        this.id = id;
        this.nome = nome;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();
}
