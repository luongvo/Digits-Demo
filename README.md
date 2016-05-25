# Digits-Demo
A demonstration of Digits - empowers your users to sign up or sign in to your app using their phone numbers

## About Digits
`Digits empowers your users to sign up or sign in to your app using their phone numbers -- an identity that they already use everyday -- without the pain of dealing with passwords.` - from [Digits homepage](https://get.digits.com/phone-based-sign-in)

### Price (Thanks to [Twitter](https://twitter.com/digits))
Free & No limitation - https://get.digits.com/pricing

### Guide to implement
Follow by the link: https://fabric.io/kits/android/digits/summary

## Troubleshooting
### Build Config
```sh
#!/usr/bin/env bash
export FABRIC_API_KEY="YOUR_FABRIC_API_KEY"
export TWITTER_KEY="YOUR_APP_TWITTER_KEY"
export TWITTER_SECRET="YOUR_APP_TWITTER_SECRET"

open /Applications/Android\ Studio.app
```

### Upgrade consumer key to allow guest auth
If you met the error look like this `Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.` from `com.twitter.sdk`. You must re-generate the `Twitter Consumer Key and Secret` of Digits from [Fabric Dashboard](https://fabric.io/dashboard).

Reference: https://twittercommunity.com/t/upgrade-consumer-key-to-allow-guest-auth/55502

## Screenshots
![](https://github.com/luongvo/Digits-Demo/blob/master/screenshots/device-2016-05-25-173130.png)
![](https://github.com/luongvo/Digits-Demo/blob/master/screenshots/device-2016-05-25-173154.png)
![](https://github.com/luongvo/Digits-Demo/blob/master/screenshots/wp_ss_20160525_0002.png)
![](https://github.com/luongvo/Digits-Demo/blob/master/screenshots/device-2016-05-25-173304.png)
![](https://github.com/luongvo/Digits-Demo/blob/master/screenshots/device-2016-05-25-173321.png)
