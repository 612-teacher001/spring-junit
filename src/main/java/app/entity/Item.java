package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "items")
public class Item {
	
	/**
	 * フィールド
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;         // 商品番号
	@ManyToOne
	@JoinColumn(name = "category_code")
	private Category category = new Category(); // 商品カテゴリ
	// private int categoryCode;
	private String name;    // 商品名
	private int price;      // 価格
	
	/**
	 * デフォルトコンストラクタ
	 */
	public Item() {}
	
	
	/**
	 * コンストラクタ
	 * @param name  商品名
	 * @param price 価格
	 */
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	/**
	 * コンストラクタ
	 * @param categoryCode 商品カテゴリコード
	 * @param name         商品名
	 * @param price        価格
	 */
	public Item(int categoryCode, String name, int price) {
		this(name, price);
		this.category.setCode(categoryCode);
	}

	/**
	 * コンストラクタ
	 * @param id　　　　　　　商品番号
	 * @param categoryCode 商品カテゴリコード
	 * @param name         商品名
	 * @param price        価格
	 */
	public Item(int id, int categoryCode, String name, int price) {
		this(categoryCode, name, price);
		this.id = id;
	}
	
	/**
	 * コンストラクタ
	 * @param id　　　　　　　商品番号
	 * @param categoryCode 商品カテゴリインスタンス
	 * @param name         商品名
	 * @param price        価格
	 */
	public Item(int id, Category category, String name, int price) {
		this(name, price);
		this.id = id;
		this.category = category;
	}

	/**
	 * カテゴリ名を取得する
	 * @return カテゴリ名
	 */
	public String getCategoryName() {
		return this.category.getName();
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", category=" + category.toString() + ", name=" + name + ", price=" + price + "]";
	}
	
}
