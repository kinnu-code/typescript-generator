# This is a forked repo

Original can be found here: https://github.com/vojtechhabarta/typescript-generator

## What the fork adds

you can tell it to render enums using fields from the enum as @JsonValue would do.
Given that we can't use the jackson annotations in pure kotlin this kind of replicates
the behaviour

## How to use

```
        mapEnum = EnumMapping.asKinnuEnum
        kinnuEnumFields = listOf("id", "level")
        kinnuEnumExcludes = listOf(
            "xyz.kinnu.dto2.account.LoginDestination",
            "xyz.kinnu.dto2.content.edits.ContentItemUserEditType",
            "xyz.kinnu.dto2.content.edits.ContentItemUserEditStatus",
            "xyz.kinnu.dto2.media.MediaStatusDto",
            "xyz.kinnu.dto2.media.MediaTypeDto",
            "xyz.kinnu.dto2.profile.DeviceType",
            "xyz.kinnu.dto2.pushnotification.PushNotificationMessageType",
        )
```

The first line `mapEnum = EnumMapping.asKinnuEnum` activates our behaviour
The second line tells it which enum fields to look for.
If it finds an enum that has one of those fields, it first produces something like this

```typescript
export enum SubscriptionStatus {
    ACTIVE = 1,
    INACTIVE = 2,
    NOT_KNOWN = 3,
}
```

The third line list enums to ignore and produce the standard output like this:

```typescript
export enum DeviceType {
    ANDROID_APP = "ANDROID_APP",
    IOS_APP = "IOS_APP",
    WEB = "WEB",
}
```

This is because I forgot to add the @JsonValue on some of the enums when converting to Kinnuverse v2 in the first place
and without those the old clients couldn't read the server responses


## How to compile this monstrosity

- Make sure you have a .m2/settings.xml with the `kinnu-gradle` and the updated token, this would have been set by the `refresh_token` script we run for gradle as well.
- activate the `local-deploy` profile in the maven tasks thingy in intellij
- in the `typescript-generator` collection in that window, run `deploy`
- Open the `/build/typescript-generator-gradle-plugin-publisher` as another project with intellij
- Run the `publishing` - `publishAllToKinnuGradle` task
- Use the plugin in a project that generates the typescript interface file