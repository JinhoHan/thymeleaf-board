package com.acma.app.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6796308717024224446L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;

	@Column
	private String title;

	@Column
	private String content;

	@Column
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdDate;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updatedDate;

	@Builder
	public Board(long idx, String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
}
