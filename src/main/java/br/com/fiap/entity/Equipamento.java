package br.com.fiap.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EQUIPAMENTO")
@SequenceGenerator(name="equipamento", sequenceName = "SQ_TB_EQUIPAMENTO", allocationSize = 1)
public class Equipamento {
	
	@Id
	@Column(name="cd_equipamento")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipamento")
	private Integer codigo;
	
	@Column(name="nm_equipamento", length= 50, nullable = false, unique = true)	
	private String nome;
	
	@Column(name="dt_instalacao", nullable = false)
	private Calendar dataLancamento;
	
	@Column(name="dt_preventiva", nullable = false)
	private Calendar dataPreventiva;
	
	@Column(name="ds_funcionamento", nullable = false, length = 40)
	private String funcionamento;
	
	@Column(name="st_ativo")
	private Boolean ativo;
	
	@Column(name="dt_cadastro", updatable = false)	
	private LocalDate dataCadastro;
	
	@Column(name="vl_faturamento", precision = 11, scale = 2)
	private BigDecimal faturamento;
	
	@Lob	
	@Column(name="ft_equipamento")
	private byte[] fotoEquipamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_setor")
	private TipoSetor setor;

	
	//Construtores
	public Equipamento() {}
	
	public Equipamento(String nome, Calendar dataLancamento, Calendar dataPreventiva,
			String funcionamento, Boolean ativo, LocalDate dataCadastro, BigDecimal faturamento, byte[] fotoEquipamento,
			TipoSetor setor) {
		this.nome = nome;
		this.dataLancamento = dataLancamento;
		this.dataPreventiva = dataPreventiva;
		this.funcionamento = funcionamento;
		this.ativo = ativo;
		this.dataCadastro = dataCadastro;
		this.faturamento = faturamento;
		this.fotoEquipamento = fotoEquipamento;
		this.setor = setor;
	}
	
	public Equipamento(Integer codigo, String nome, Calendar dataLancamento, Calendar dataPreventiva,
			String funcionamento, Boolean ativo, LocalDate dataCadastro, BigDecimal faturamento, byte[] fotoEquipamento,
			TipoSetor setor) {
		this(nome, dataLancamento, dataPreventiva, funcionamento, ativo, dataCadastro,
				faturamento, fotoEquipamento, setor);
		this.codigo = codigo;
	}
	

	@PrePersist 
	public void executar() {
		System.out.println("Cadastrando um equipamento...");
	}
				
	@PostLoad 
	public void carregar() {
		System.out.println("Carregando um equipamento...");
	}
	
	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Calendar getDataPreventiva() {
		return dataPreventiva;
	}

	public void setDataPreventiva(Calendar dataPreventiva) {
		this.dataPreventiva = dataPreventiva;
	}

	public String getFuncionamento() {
		return funcionamento;
	}

	public void setFuncionamento(String funcionamento) {
		this.funcionamento = funcionamento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(BigDecimal faturamento) {
		this.faturamento = faturamento;
	}

	public byte[] getFotoEquipamento() {
		return fotoEquipamento;
	}

	public void setFotoEquipamento(byte[] fotoEquipamento) {
		this.fotoEquipamento = fotoEquipamento;
	}

	public TipoSetor getSetor() {
		return setor;
	}

	public void setSetor(TipoSetor setor) {
		this.setor = setor;
	}
	
}
