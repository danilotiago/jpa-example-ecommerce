package app.projetaria.appcommerce.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import app.projetaria.appcommerce.enums.StatusPedido;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	@Column(name = "data_conclusao")
	private LocalDateTime dataConclusao;

	@Column(name = "nota_fical_id")
	private Integer notaFiscalId;

	private Double total;
	
	@Embedded
	private Endereco enderecoEntrega;

	// pega efetivamente a String do Enum e grava no banco
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Integer getNotaFiscalId() {
		return notaFiscalId;
	}

	public void setNotaFiscalId(Integer notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Endereco getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(Endereco enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", dataConclusao=" + dataConclusao
				+ ", notaFiscalId=" + notaFiscalId + ", total=" + total + ", enderecoEntrega=" + enderecoEntrega
				+ ", status=" + status + "]";
	}

}
