package com.acma.app.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Board implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6796308717024224446L;
	
	private Long idx;
}
