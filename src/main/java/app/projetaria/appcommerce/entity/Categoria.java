package app.projetaria.appcommerce.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "categoria_raiz")
	private Categoria categoriaRaiz;

	@OneToMany(mappedBy = "categoriaRaiz")
	private List<Categoria> categoriasFilha;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoriaRaiz() {
		return categoriaRaiz;
	}

	public void setCategoriaRaiz(Categoria categoriaRaiz) {
		this.categoriaRaiz = categoriaRaiz;
	}

	public List<Categoria> getCategoriasFilha() {
		return categoriasFilha;
	}

	public void setCategoriasFilha(List<Categoria> categoriasFilha) {
		this.categoriasFilha = categoriasFilha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", categoriaRaiz=" + categoriaRaiz + ", categoriasFilha="
				+ categoriasFilha + "]";
	}

}
