package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	/**
	 * カテゴリ検索：SELECT * FROM items WHERE category_code = :categoryId
	 * @param categoryCode カテゴリコード
	 * @return 商品リスト
	 */
	List<Item> findByCategoryCode(int categoryCode);

}
