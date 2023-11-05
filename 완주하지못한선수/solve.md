### 완주하지 못한 선수

# 해결과정

길이가 1차이이고 원소가 모두 동일한 두 문자열이 있다.
긴 배열에서 짧은 배열쪽에 없는 1개의 문자열을 찾으면 된다.

처음으로 시도한건 두 배열을 정렬한 뒤 짧은 배열 size만큼 compare했다. 

```
        String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0 ; i < completion.length ; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}
		if (answer.equals(""))
			answer = participant[participant.length - 1];
```

정확성은 통과가 됐는데 효율성에서 실패했다. 문자열을 정렬하는데 시간이 오래걸리는것으로 추측

HashMap을 이용해서 첫번째 배열을 전부 put하고 두번째 배열을 돌면서 remove했다.

해치운줄 알았으나 배열의 요소중 중복인 값이 있으면 hashmap은 중복키를 지원하지 않기 때문에 원하는 동작을 하지 않는다.

2개를 저장해도 키가 똑같으면 remove한번에 전부 사라지는 것!

put할 때 이미 존재하는 키 이면 value를 하나씩 올렸다.

remove하기전에 해당 키에 대해 value를 하나씩 내리고 0이되면 remove로 해결

```
        String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0 ; i < participant.length ; i++) {
			//중복 한번에 제거 방지를 위해 value 활용
			if (map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i]) + 1);
			} else
				map.put(participant[i],1);
		}
		for (int i = 0 ; i < completion.length ; i++) {
			map.put(completion[i], map.get(completion[i]) - 1);
			//value가 0이되야 삭제한다.
			if (map.get(completion[i]) == 0)
				map.remove(completion[i]);
		}
		for (String key : map.keySet()) {
			answer = key;
		}
		return answer;
```