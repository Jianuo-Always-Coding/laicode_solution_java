# String II

## Right shift by n charactrs

```java
int len = n % array.length;
if (len == 0) {
    return input;
}
reverse(array, 0, array.length - 1);
reverse(array, 0, len - 1);
reverse(array, len, array.length - 1);
```

> Because len is the length of the reverse substring, so we need to use **len - 1** to do reverse.

## Longest Substring Without Repeating Characters

> Easy to make a mistake when move 'start'.

## All Anagrams

> Easy to make a mistake

## String repalce

Don't forget when finish the following judgement

```java
while (index <= input.length() - source.length()) {
    ...
}
```

We must do the following action to add rest characters.

```java
while (index < input.length()) {
    sb.append(input.charAt(index++));
}
```
