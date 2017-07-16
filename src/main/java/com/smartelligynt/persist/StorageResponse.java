package com.smartelligynt.persist;

/**
 * 
 * @author r.karwa
 * {
  "_index": "users",
  "_type": "5bc9fdc9-7952-4680-94f4-43150e35768d",
  "_id": "AVzifaAbstmYPxIxNkq2",
  "_version": 1,
  "result": "created",
  "_shards": {
    "total": 2,
    "successful": 1,
    "failed": 0
  },
  "created": true
}
 *
 */
public class StorageResponse {
	
	private String _index;
	private String _type;
	private  String _id;
	private String result;
	//private boolean created;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
