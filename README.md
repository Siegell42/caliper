# Caliper

[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue?logo=kotlin)](https://kotlinlang.org)

---

## Назначение

Caliper — это инструмент для анализа кода.
Он позволяет:
- Оценить комплексность классов.
- Визуально изучить последовательности вызовов и другие диаграммы.
- Получить возможные рекомендации для рефакторинга.

Статус проекта: ранняя стадия разработки. Возможны изменения в API и архитектуре.

## Как использовать

1.	Склонируйте репозиторий.
2.	Запустите сборку (и генерацию отчёта, если нужно) командой:
```bash
./gradlew build
```
При необходимости настройте свои аннотации для анализа или используйте уже имеющиеся (например, @CaliperTarget).
3. Результаты (отчёты) могут быть доступны в `build/generated/ksp/main/resources/caliper/report.md`

## Roadmap

- [x] начальная подготовка проекта
- [ ] парсинг класса под аннотацией
- [ ] генерация UML-диаграмм
- [ ] анализ класса
- [ ] рекомендации к рефакторингу

---

## Purpose

Caliper is a code analysis tool.
It allows you to:
-	Evaluate class complexity.
-	Visually explore call sequences and other diagrams.
-	Receive potential refactoring recommendations.

Project status: early development stage. The API and architecture may change.

## Usage

1.	Clone the repository.
2.	Run the build (and report generation if needed):
```bash
./gradlew build
```
You can configure your annotations for analysis or use the existing ones (e.g., @CaliperTarget).
3.	Results (reports) can be found in build/generated/ksp/main/resources/caliper/report.md

## Roadmap

- [x] Initial project setup
- [ ] Class parsing under annotation
- [ ] UML diagram generation
- [ ] Class analysis
- [ ] Refactoring recommendations