package com.example.myahrtc.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myahrtc.common.CmMap;
import com.example.myahrtc.service.RtcCostService;

@Controller
@RequestMapping("/rtc/cost")
public class RtcCostController {

	private final RtcCostService rtcCostService;

	public RtcCostController(RtcCostService rtcCostService) {
		this.rtcCostService = rtcCostService;
	}

	@RequestMapping("/list.do")
	public String list(@RequestParam("carCd") String carCd, Model model) {
		CmMap condition = new CmMap();
		condition.put("carCd", carCd);

		List<CmMap> list = rtcCostService.getCostList(condition);
		model.addAttribute("list", list);
		model.addAttribute("totalCost", rtcCostService.getTotalCost(carCd, null, null));
		return "rtc/cost/list";
	}
}
