package com.bia.domain;

import java.nio.ByteBuffer;
import java.util.Date;

import org.springframework.cassandra.core.Ordering;
import org.springframework.cassandra.core.PrimaryKeyType;
//import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

//CREATE COLUMNFAMILY emp ( id varchar PRIMARY KEY, username varchar, joinDate timestamp, storageSize double);
//CREATE INDEX userIndex ON emp (username);
@Table
public class Emp {

	//@Id
	//@PrimaryKeyColumn(name = "id", ordinal = 1, type=PrimaryKeyType.PARTITIONED)
	@PrimaryKey
	protected String id;

	protected String username;

	protected Date joinDate;

	protected Double storageSize;

	protected ByteBuffer img;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Double getStorageSize() {
		return storageSize;
	}

	public void setStorageSize(Double storageSize) {
		this.storageSize = storageSize;
	}

	public ByteBuffer getImg() {
		return img;
	}

	public void setImg(ByteBuffer img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", username=" + username + ", joinDate="
				+ joinDate + ", storageSize=" + storageSize + "]";
	}

}
