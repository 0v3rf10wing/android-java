# AndroidRingtoneTest

A simple application to select android inbuilt sound.

## Type of Sound Support

The sound support are from [RingtoneManager](https://developer.android.com/reference/android/media/RingtoneManager) class

```java
RingtoneManager ringtoneManger = new RingtoneManager(this);
```

- Notification

```java
ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION);
```

- Alarm

```java
ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION);
```

- Ringtone

```java
ringtoneManager.setType(RingtoneManager.TYPE_RINGTONE);
```

- All

```java
ringtoneManager.setType(RingtoneManager.TYPE_ALL);
```
