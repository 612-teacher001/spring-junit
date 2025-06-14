package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "m_categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;    // 商品カテゴリコード
	private String name; // カテゴリ名
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Category() {}
	
	/**
	 * コンストラクタ
	 * @param code カテゴリコード
	 * @param name カテゴリ名
	 */
	public Category(int code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [code=" + code + ", name=" + name + "]";
	}
	
}
