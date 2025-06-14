package app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import app.controller.BaseController;

/**
 * 最初に起動されるコントローラ：ここでは直接インデックスに遷移しているだけだが、ログイン画面に遷移できる
 */
@Controller
public class IndexController extends BaseController {
	
	/**
	 * 業務パネル画面を表示する
	 * @param model 共有のデータ置き場
	 * @return Thymeleafテンンプレート名（index.html）
	 */
	@GetMapping("/")
	public String index(Model model) {
		// タイトルバー表示
		setTitle("インデックス", model);
		// 画面遷移
		return "index";
	}
	
}
