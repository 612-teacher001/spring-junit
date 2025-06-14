package app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.Item;
import app.repository.ItemRepository;

@Controller
@RequestMapping("/items")
public class ItemController extends BaseController {
	
	@Autowired
	ItemRepository repository;
	
	/**
	 * 商品一覧画面を表示する
	 * @param model 共有のデータ置き場
	 * @return Thymeleafテンプレート名（items/list.html）
	 */
	@GetMapping("/list")
	public String index(Model model) {
		// すべての商品を取得
		List<Item> list = repository.findAll();
		
		// データ置き場に放置
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("items", list);
		attributes.put("pageTitle", "商品一覧");
		this.setParameters(attributes, model);
		
		// 画面遷移
		return "items/list";
	}
}
