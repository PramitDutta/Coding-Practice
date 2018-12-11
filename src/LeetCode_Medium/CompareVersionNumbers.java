package LeetCode_Medium;

public class CompareVersionNumbers {
	public static void compareVersion(String version1, String version2) {
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		for (String s : ver1) {
			System.out.println(s);
		}
		// return 0;

	}

	public static void main(String[] args) {
		compareVersion("1.2", "2.3");
	}
}
