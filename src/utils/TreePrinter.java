package utils;

import NodePackage.*;

public class TreePrinter {

	public static void print(AbstractTreeNode root) {
		String s = root.getName()+"-";
		for (int i = 0; i < root.getChildren().size(); i++) {
			AbstractTreeNode child = root.getChildren().get(i);
			if (child != null) {
				System.out.print(s);
				p(child, i, root.getName().length()+1);
				s = "\n"+f(root.getName().length())+"\\";
			}
		}
		System.out.println();
	}

	static void p(AbstractTreeNode h, int k, int space) {
		System.out.print(h.getName());
		String s = "-";
		for (int i = 0; i < h.getChildren().size(); i++) {
			AbstractTreeNode child = h.getChildren().get(i);
			if (child != null) {
				System.out.print(s);
				p(child, i, space + h.getName().length()+1);
				if (s.equals("-"))
					s = "";
				s += "\n" + f(space+h.getName().length()) + "\\";
			}
		}
	}

	static String f(int n) {
		String out = "";
		while (n-- > 0)
			out += " ";
		return out;
	}

}
