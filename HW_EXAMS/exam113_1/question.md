
## MID-Test-113-1

### 1. 基本題 （50%）
例行賽的時候非假日票價 500 元，假日 600 元，如果是會員則打八折，但如果是買套票則一律為 250 元。季後賽票價 1000 元，會員打八折但沒有套票，也不分是否為例假日。寫一個 function 來回傳價格，並進行測試。並透過 PMD 改善你的程式碼，並產生報告。

評分：
* [ ] 能夠設計豐富而有效的測試案例（以表格規劃之）
* [ ] 完成程式可以執行，並以 JUnit 測試 
* [ ] 成功完成 PMD 程式靜態檢測的報告
* [ ] 可以依據 PMD 建議，改善程式碼

**兩題完成後請先給老師，助教初評**

**如同作業繳交一樣，請交 maven 專案檔的壓縮，需要自評與畫面貼圖**

### 2. 美國大選（50%）

美國大選的勝負是比較選舉人票數（electoral votes）的多寡，而非普選人數（popular votes），以下的資料每一行代表一個州。每一列代表一個屬性，依次為州名、選舉人票數、一號候選人得票數、二號候選人得票數（"State", "ElectoralVotes", "C1Votes", "C2Votes"）。

以下是2020 年選舉的部分資料：
```
State,EV,Biden,Trump
Alabama,9,849624,1441170
Hawaii,4,366130,196864
```
表示 Alabama 有 9 張選舉人票，Biden 拿了 849624 張普選人口票，小於 Trump 的 1441170，所以這一州 Trump 拿下了 9 張選舉人票，而拜登則為 0 票。反之，Hawaii 由 Biden 拿下 4 張。

![](votes2020.png)

設計一個 Java class `USAElection`, 內有 `getElectionResult(electionData)`，將會回傳一個陣列 `{Winner, Winner_electoral_votes, AlignOrSplit}`。
* Winner: 勝者的名字 (如 Biden)，如平手則為 "NONE"。
* Winner_electoral_votes: 勝者的選舉人票數 (如 306)。如平手則為 -1。
* AlignOrSplit: 選舉人票數勝負與普選人票數勝負一致則為 "Align"（符合-高票者勝選），否則為 "Split" （分裂-高票者落選）。如平手則為 "X"。

注意
* 請參考 [USAElection](./resources/USAElection.java), [USAElectionTest](./resources/USAElectionTest.java)的程式進行修改，該程式有少許錯誤，請善用除錯技巧進行除錯。
* 請設計測試策略並說明之
* 選舉人票總合必須為 538 票，若不符合，則拋出例外
* 測試資料請參考 votes2020.csv; 當然，你必須設計更多的測試案例與資料
* 多數州選舉人票得取得是「贏者全拿的」策略，除了 Nebraska (內布拉斯加州) 與 Maine (
5 / 5,000 緬因州) 以外-- 概略來說這兩州是依據普選票數來進行比例分配的，請依此需求修改程式，並設計測試案例。

評分
* [ ] 能修正程式，使之可以進行測試
* [ ] 測試策略說明完整，能夠因此產生豐富而有效的測試案例
* [ ] 能夠修改 Nebraska/Maine 的特殊處理，並進行測試
* [ ] 透過 JUnit 進行自動化的測試，把各種情境都確認無誤
* [ ] 改善 JUnit 的程式使之模組化，方便進行多個資料測試

**兩題完成後請先給老師，助教初評**

**如同作業繳交一樣，請交 maven 專案檔的壓縮，需要自評與畫面貼圖**