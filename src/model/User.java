package model;

import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String name;
	private String pass;

	public User() {}
	public User(String id, String name, String pass) {
		this.id = id;
		this.name = name;
		this.pass = pass;
	}
	/**
	 * idを取得します。
	 * @return id
	 */
	public String getId() {
	    return id;
	}
	/**
	 * idを設定します。
	 * @param id id
	 */
	public void setId(String id) {
	    this.id = id;
	}
	/**
	 * nameを取得します。
	 * @return name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * nameを設定します。
	 * @param name name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * passを取得します。
	 * @return pass
	 */
	public String getPass() {
	    return pass;
	}
	/**
	 * passを設定します。
	 * @param pass pass
	 */
	public void setPass(String pass) {
	    this.pass = pass;
	}
}
