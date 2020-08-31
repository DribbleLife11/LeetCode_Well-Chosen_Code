class Zconvert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int j = 0;
        int flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(j).append(c);
            if (j == 0 || j == numRows - 1) {
                flag =  -flag;
            }
            j += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}
