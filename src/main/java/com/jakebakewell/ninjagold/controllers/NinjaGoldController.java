package com.jakebakewell.ninjagold.controllers;

import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	@RequestMapping("/")
	public String ninjaGold(HttpSession session) {
		ArrayList<String> activity = new ArrayList<String>();
		if (session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "gold.jsp";
	}
	
	@RequestMapping("/processgold")
	public String processGold(HttpSession session, @RequestParam(value="gold_acquisition_method") String goldMethod) {
		if (goldMethod.equals("farm")) {
			Random rand = new Random();
			Integer gold = rand.nextInt(21 - 10) + 10;
			Integer goldCount = (Integer) session.getAttribute("gold");
			goldCount += gold;
			session.setAttribute("gold", goldCount);
			Date currdate = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY hh:mm a");
			String date = dateformat.format(currdate);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "<p class='greentext'>You earned " + gold + " gold from the farm " + date+ "</p>");
			session.setAttribute("activity", activity);
		}
		if (goldMethod.equals("cave")) {
			Random rand = new Random();
			Integer gold = rand.nextInt(11 - 5) + 5;
			Integer goldCount = (Integer) session.getAttribute("gold");
			goldCount += gold;
			session.setAttribute("gold", goldCount);
			Date currdate = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY hh:mm a");
			String date = dateformat.format(currdate);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "<p class='greentext'>You earned " + gold + " gold from the cave " + date+ "</p>");
			session.setAttribute("activity", activity);
		}
		if (goldMethod.equals("house")) {
			Random rand = new Random();
			Integer gold = rand.nextInt(6 - 2) + 2;
			Integer goldCount = (Integer) session.getAttribute("gold");
			goldCount += gold;
			session.setAttribute("gold", goldCount);
			Date currdate = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY hh:mm a");
			String date = dateformat.format(currdate);
			ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
			activity.add(0, "<p class='greentext'>You earned " + gold + " gold from the house " + date+ "</p>");
			session.setAttribute("activity", activity);
		}
		if (goldMethod.equals("casino")) {
			Random rand = new Random();
			Integer plusminus = rand.nextInt(3 - 1) + 1;
			Integer gold = rand.nextInt(51);
			if (plusminus == 2) {
				gold = gold * -1;
				Integer goldCount = (Integer) session.getAttribute("gold");
				goldCount += gold;
				session.setAttribute("gold", goldCount);
				Date currdate = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY hh:mm a");
				String date = dateformat.format(currdate);
				ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
				activity.add(0, "<p class='redtext'>You lost " + gold + " gold from the casino " + date+ "</p>");
				session.setAttribute("activity", activity);
			}
			else {
				Integer goldCount = (Integer) session.getAttribute("gold");
				goldCount += gold;
				session.setAttribute("gold", goldCount);
				Date currdate = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY hh:mm a");
				String date = dateformat.format(currdate);
				ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
				activity.add(0, "<p class='greentext'>You earned " + gold + " gold from the casino " + date+ "</p>");
				session.setAttribute("activity", activity);
			}
		}
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
