package br.com.drope.vuttrapi.modules.Tools.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.drope.vuttrapi.modules.Tags.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "TOOL")
@Data
@AllArgsConstructor
public class Tool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LINK")
	private String link;
	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TOOL_HAS_TAG", joinColumns = @JoinColumn(name = "TOOL_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
	private Set<Tag> tags = new HashSet<>();

	public Tool() {
	}
}
