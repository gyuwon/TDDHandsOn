# 현실 세상의 TDD 실습 코드 
# Tutorials for Real World Test-Driven Development (TDD)

Fast campus 강의 ['현실 세상의 TDD'](https://www.fastcampus.co.kr/dev_red_ygw) 실습에 사용된 예제 코드를 제공합니다.

Provides the sample code used in the Fast Campus class ['Real World TDD'](https://www.fastcampus.co.kr/dev_red_ygw).

> 예제 코드는 강의 촬영 전에 미리 준비되었고 강의 촬영 시 라이브 코딩이 진행되었기 때문에 세부 코드는 강의 영상에서 보는 것과 다를 수 있습니다.

> The code may differ from what you see in the lecture video because the sample code was prepared before the lecture shoot and live coding was performed during the shoot.

## 질문 및 토론
## QA & Discussions

TDD 또는 강의와 관련된 질문과 토론을 위해 Discord 서버를 만들었습니다. 여기 [**초대 링크**](https://discord.gg/NjC9r6kvUz)를 통해 들어오실 수 있습니다. 이 저장소에 이슈를 등록해주셔도 됩니다. 두 소통 채널은 각자 장단점이 있으니 주제에 따라 편하게 적합한 수단을 선택해 주세요.

We have created a Discord server for QA and discussions related to TDD or the lectures. Here [**Invitation link**](https://discord.gg/NjC9r6kvUz) You can also register any issues in this repository. Each of the two communication channels has its own pros and cons, so please choose the appropriate means according to the topic.

## 프로젝트
## Projects

### Variance
- 분산 통계량을 계산하는 .NET 5 콘솔 응용프로그램 입니다.
- .NET 5 console application that calculates variance in statistics.

### text-refiner
- 문자열 정제 기능을 제공하는 JavaScript 라이브러리 입니다.
- JavaScript library that provides string refinement.

### NumberGuessing
- Java로 작성된 1과 100 사이 임의의 정수를 맞추는 텍스트 기반 게임입니다. 단일 플레이어 모드와 다중 플레이어 모드를 제공합니다.
- A text-based game that matches any integer between 1 and 100 written in Java. Provides both single/multiple-player modes.

### comment-list
- 코멘트 목록을 관리하는 React 응용프로그램 입니다.
- React application that manages the comment list.

### ProductImporter
- 여러 상품 공급자로부터 상품을 공급받아 인벤토리에 동기화하는 프로세스를 제공하는 Java 라이브러리 입니다.
- A Java library that provides the process of receiving products from multiple commodity providers and synchronizing them to the inventory.

### Inventory
- 온라인으로 판매할 상품 정보가 저장된 인벤토리를 관리하는 시스템입니다. ASP.NET Core 5와 React를 사용해 구현됩니다.
- A system that manages the inventory containing product information to be sold online. Implemented using ASP.NET Core 5 and React.

## 세션 별 코드
## Code by Session

태그를 통해 실습이 포함된 각 세션 별 실습 진행에 기반이되는 코드와 실습이 완료된 코드를 볼 수 있습니다.

The tags allow you to view the code based on the lab progress for each session that includes the lab and the code.

### 1부. 테스트 주도 개발 기초
### Part 1. Test Driven Development Fundamentals

| 세션 (Session)    |              기반 코드 (Based Code) |       완료 코드    (Completed Code)       |
| ---------------- | :---------------------------------: | :-----------------------------------------: |
| 코드 기능 명세 (Code Functional Specification)  |  [`1-1-base`](../../tree/1-1-base)  |  [`1-1-complete`](../../tree/1-1-complete)  |
| 단위 테스트 (Unit Tes)     |  [`1-4-base`](../../tree/1-4-base)  |  [`1-4-complete`](../../tree/1-4-complete)  |
| 테스트 우선 개발 (Test First Development) |  [`1-5-base`](../../tree/1-5-base)  |  [`1-5-complete`](../../tree/1-5-complete)  |
| 정리된 코드 (Organized Code)      |  [`1-6-base`](../../tree/1-6-base)  |  [`1-6-complete`](../../tree/1-6-complete)  |
| 테스트 주도 개발 (Test Driven Development) |  [`1-7-base`](../../tree/1-7-base)  |  [`1-7-complete`](../../tree/1-7-complete)  |
| 장난감-1  (Toy Example-1)       |       [`1-9`](../../tree/1-9)       |                     N/A                     |
| 장난감-2  (Toy Example-2)         | [`1-10-base`](../../tree/1-10-base) | [`1-10-complete`](../../tree/1-10-complete) |
| 장난감-3   (Toy Example-3)      | [`1-11-base`](../../tree/1-11-base) | [`1-11-complete`](../../tree/1-11-complete) |

### 2부. 테스트 주도 개발의 깊은 곳
### Part 2. Deep in Test-Driven Development

| 세션 (Session)    |              기반 코드 (Based Code) |       완료 코드    (Completed Code)       |
| ------------------------------ | :---------------------------------: | :-----------------------------------------: |
| 환경 변화와 적응력 (Environmental Change & Adaptability)|  [`2-2-base`](../../tree/2-2-base)  |  [`2-2-complete`](../../tree/2-2-complete)  |
| 입력과 출력       (Input & Output)              |  [`2-3-base`](../../tree/2-3-base)  |  [`2-3-complete`](../../tree/2-3-complete)  |
| 테스트 대역    (Test Band)                |  [`2-4-base`](../../tree/2-4-base)  |  [`2-4-complete`](../../tree/2-4-complete)  |
| Mockists vs. Classicists       |  [`2-5-base`](../../tree/2-5-base)  |  [`2-5-complete`](../../tree/2-5-complete)  |
| Should I test private methods? |  [`2-6-base`](../../tree/2-6-base)  |  [`2-6-complete`](../../tree/2-6-complete)  |
| 인수 테스트 주도 개발  (Acquisition Test Driven Development)       | [`2-10-base`](../../tree/2-10-base) | [`2-10-complete`](../../tree/2-10-complete) |

## 개발 도구 (Development Tools)

### .NET 5 SDK
- https://dotnet.microsoft.com/download/dotnet/5.0

### Node.js
- https://nodejs.org/en/download/

### OpenJDK 11
- https://github.com/AdoptOpenJDK/openjdk11-binaries/releases

### Gradle
- https://gradle.org/install/

### Visual Studio Code
- https://code.visualstudio.com/

설치된 확장 (Installed Extensions)
- [Babel JavaScript](https://marketplace.visualstudio.com/items?itemName=mgmcdermott.vscode-language-babel)
- [C#](https://marketplace.visualstudio.com/items?itemName=ms-dotnettools.csharp)
- [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Prettier - Code formatter](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)

### Visual Studio
- Visual Studio Community 2019

https://visualstudio.microsoft.com/vs/
