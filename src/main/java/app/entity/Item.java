package app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@Column(name = "category_code")
	private int categoryCode; // 商品カテゴリ
	private String name;    // 商品名
	private int price;      // 価格
	
}
