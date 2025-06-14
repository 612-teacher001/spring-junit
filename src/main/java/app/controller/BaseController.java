package app.controller;

import java.util.Map;
import java.util.Set;

import org.springframework.ui.Model;

/**
 * Controllerクラスが継承する基底クラス：共通で利用できるメソッドを提供する
 */
public class BaseController {
	
	/**
	 * データ置き場にデータを置く
	 * @param map 対象データのMap
	 * @param model 共有のデータ置き場
	 */
	protected void setParameters(Map<String, Object> map, Model model) {
		Set<String> keys = map.keySet();
		for (String key : keys) {
			model.addAttribute(key, map.get(key));
		}
	}
	
	/**
	 * タイトルバーにページタイトルを表示する
	 * @param pageTitle 表示するページタイトル
	 * @param model 共有のデータ置き場
	 */
	protected void setTitle(String pageTitle, Model model) {
		model.addAttribute("pageTitle", pageTitle);
	}

}
