# java-vendingmachine

# 구현 명세

## 입력

### 공통

- 사용자가 아무런 입력을 하지 않았을 경우 재입력 하도록 한다.
- 개수나 금액 등의 숫자만 필요한 입력값의 경우 문자가 들어올 경우를 검증한다. -> 검증 실패했을 경우 재입력 하도록 한다.

### 기능

- 사용자에게 자판기의 보유 금액을 입력받는다.

- 사용자에게 상품명, 개수, 금액을 입력받는다.
    1. 사용자의 입력을 받으면 item 마다는 ';'로 분리, 아이템의 각 속성마다는 ','로 분리한다.

- 사용자에게 투입 금액을 입력받는다.

- 사용자에게 구매할 상품명을 입력받는다.
    1. 해당 상품명이 존재하지 않을 경우 에러 메시지를 출력하고 재입력 받는다.

## 자판기

- 보유 금액
    1. 입력받은 금액으로 동전을 무작위로 생성한다.
    2. 동전은 500원, 100원, 50원, 10원이 있기 때문에 해당 동전으로만 생성한다.

- 물품 구매
    1. 최소 개수의 동전으로 잔돈을 돌려준다.
    2. 남은 금액이 상품 최소 금액보다 적거나 모든 상품이 소진 된 경우 잔돈을 모두 돌려준다.
        - 자판기에서는 상품 최소 금액과, 전체 물품의 개수를 가지고 있어야 처리하기 편할 것 같다.
    3. 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.

## 출력

- 사용자의 입력을 요구하는 메시지를 출력한다.
    1. 자판기가 보유하고 있는 금액을 입력해 주세요.
    2. 상품명과 수량, 금액을 입력해 주세요.
    3. 투입 금액을 입력해 주세요.
       <모든 초기값을 입력 받은 후>
    4. 구매할 상품명을 입력해 주세요.

- 각 세션마다 남은 금액을 출력한다.
- '남은 금액 < 상품 최소금액' 일 경우 남은 잔돈을 출력한다.