package com.smartelligynt.api;

/**
 * 
 * @author spattan { "_id": "b32f6cec-454c-44e1-971c-f4a38eb5ce9f", "_index":
 *         "users", "_source": { DOCUMENT }, "_type": "user", "_version": 8,
 *         "found": true }
 *
 */
public class GetResponse<T> {

	private String _index;
	private String _type;
	private String _id;
	private T _source;
	private String _version;

	public String get_index() {
		return _index;
	}

	public void set_index(String _index) {
		this._index = _index;
	}

	public String get_type() {
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public T get_source() {
		return _source;
	}

	public void set_source(T _source) {
		this._source = _source;
	}

	public String get_version() {
		return _version;
	}

	public void set_version(String _version) {
		this._version = _version;
	}
}
