import  { test, expect } from '@playwright/test';
import { chromium } from 'playwright-core';

test('テストのデバッグ',async () => {
  const browser = await chromium.launch({
    channel: 'chrome', //ここで指定することで既存のchromeを利用可能
    headless: false, //falseの場合はブラウザ上での動きを確認しながら実行可能
  }); //①ブラウザ起動
  const page = await browser.newPage(); //②ページ生成
  // ブラウザを開き、指定された URL に移動します。
  await page.goto('https://www.example.com');

  // タイトルが "Example Page" であることを確認します。
  const title = await page.title();
//   expect(title).toBe('Example Page');

  // "Hello, world!" というテキストを含む要素を検索します。
  const text = await page.textContent('h1');
//   expect(text).toBe('Hello, world!');
});
