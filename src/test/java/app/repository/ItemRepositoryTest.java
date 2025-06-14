package app.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.entity.Category;
import app.entity.Item;

@SpringBootTest
@Transactional
class ItemRepositoryTest {

	/** テスト対象クラス */
	@Autowired
	ItemRepository sut;
	
	@Test
	@DisplayName("Test03: 商品カテゴリ「３」の商品は３個取得できる")
	void test03() {
		// setup
		int target = 3;
		List<Item> expected = new ArrayList<Item>();
		Category category = new Category(target, "ゲーム");
		expected.add(new Item(7, category, "パズルゲーム", 780));
		expected.add(new Item(8, category, "Invader Fighter", 3400));
		expected.add(new Item(9, category, "Play the BasketBall", 2200));
		// execute
		List<Item> actual = sut.findByCategoryCode(target);
		// verify
		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).toString(), actual.get(i).toString());
		}
	}
	
	@Test
	@DisplayName("Test02: 商品番号1の商品のカテゴリは「本」である")
	void test02() {
		// setup
		int target = 1;
		String expected = "本";
		// execute
		String actual = sut.findById(target).get().getCategoryName();
		// verify
		assertEquals(expected.toString(), actual.toString());
	}
	
	@Test
	@DisplayName("Test01: 商品番号「1」の商品の商品カテゴリは「本」である")
	void test01() {
		// setup
		int target = 1;
		Category category = new Category(target, "本");
		Item expected = new Item(1, category, "Javaの基本", 2500);
		// execcute
		Item actual = sut.findById(target).get();
		// verify
		assertEquals(expected.toString(), actual.toString());
	}

}
