package com.example.harrispaul.aggregator;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Harrispaul on 3/14/2016.
 */

public class MainActivity extends AppCompatActivity {

    ListView list;
    String jsonStr = "{\"productInfoList\":[{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2YBFZTV3S\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6 Plus\",\"productDescription\":\"\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-400x400-imaeymdqartzwz76.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-200x200-imaeymdqartzwz76.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-original-imaeymdqartzwz76.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-800x800-imaeymdqartzwz76.jpeg\"},\"maximumRetailPrice\":{\"amount\":65000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":50890.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6-plus/p/itme7zgymhjqjccq?pid=MOBEYHZ2YBFZTV3S&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":false,\"emiAvailable\":null,\"discountPercentage\":21.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Silver\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYGPZZV9GQWZZ, MOBEYHZ2SSKPYGRK, MOBEYHZ2YBFZTV3S]\",\"colorVariants\":\"[MOBEFJG74WYMR4ZJ, MOBEFJG77J8DD6Z4, MOBEFJG77RWZQ4YJ, MOBEFJG7FS3CPHQZ, MOBEFJG7KHUB4S7Y, MOBEFJG7Q6AAUVGM, MOBEFJG7RZNK3YNV, MOBEFJG7YA8Y89JD, MOBEFJG7ZZUGGTT9, MOBEYGPZZV9GQWZZ, MOBEYHZ28ZYTRJYM, MOBEYHZ2JRQ6UVYF, MOBEYHZ2RVZHCMQK, MOBEYHZ2SSKPYGRK, MOBEYHZ2VXZM8HZD, MOBEYHZ2XVMKU4QN, MOBEYHZ2Z8N6RDFE]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2JHVFHFBG\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-400x400-imaeymdqs5gm5xkz.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-200x200-imaeymdqs5gm5xkz.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-original-imaeymdqs5gm5xkz.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-800x800-imaeymdqs5gm5xkz.jpeg\"},\"maximumRetailPrice\":{\"amount\":71500.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":59775.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8ra5z7yx5c9j?pid=MOBEYHZ2JHVFHFBG&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":false,\"emiAvailable\":null,\"discountPercentage\":16.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Space Grey\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ254METXXB, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYGPZAHZQMCKZ\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"The bigger the better - the Apple iPhone 6 is an exemplar of this phrase. The meticulously crafted iPhone 6 is truly an epitome of great taste and elegance. Beautiful Unibody Design Extremely thin, the iPhone 6 flaunts a seamless design with the smooth blend of anodised aluminium, stainless steel and the curved, polished glass. Incredibly light, the beautifully crafted iPhone 6 feels great in your hands. Thanks to its innovative design, the iPhone 6 provides an intuitive experience and is extremely easy to use. Brilliant Display Featuring the thinnest and most advanced Multi-Touch display ever made, the Apple iPhone 6 promises a high-contrast output with incredible colors and brightness on its 4.7 inch Retina HD display. A resolution of 1334x750 pixels, clear wide-angle viewing and an improved polariser - the iPhone 6 truly offers a bigger and better display. Power-Packed Performance Thanks to the all-new A8 processor with 64-bit architecture and an advanced 20 nanometre process, the iPhone 6 delivers an incredibly powerful performance while being extremely efficient. Get up to 50x faster CPU performance and up to 84x faster GPU performance with the iPhone 6. M8 Motion Coprocessor & Sensors Improve your iPhone's power efficiency with the M8 Motion Coprocessor that continuously measures data from your iPhone's different sensors such as accelerometer, compass, gyroscope and the new barometer. Camera Photos or videos - there is nothing that can beat the iPhone 6's iSight camera. The iPhone 6's 8 MP iSight camera gets new features such as a new sensor with Focus Pixels, improved face detection and exposure control. Also, now you can take amazing 1080p HD videos with the world's most popular camera. Security Make life easier with the iPhone 6's breakthrough Touch ID technology. Now you can securely access your phone with your fingerprint - no more worries about forgetting your pass code ever again. Moreover, the iPhone 6 lets you use your fingerprint to securely make purchases on iTunes or the App Store. Operating System The iPhone 6 comes with the biggest iOS release ever - the iOS 8. Featuring new capabilities and features, the world's advanced mobile operating system - the iOS 8 - gives you an incredible experience on your iPhone 6. Connectivity Thanks to the advanced Wi-Fi support with fast wireless performance, you can keep up with the world around you easily. Moreover, the iPhone 6 comes with Bluetooth and 3G support. Battery Take advantage of all the features of your highly efficient Apple iPhone 6 which boasts of an amazing battery life with up to 14 hours of 3G talk time and up to 250 hours of standby.\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-400x400-imaeymdqym6hsu7f.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-200x200-imaeymdqym6hsu7f.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-original-imaeymdqym6hsu7f.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-800x800-imaeymdqym6hsu7f.jpeg\"},\"maximumRetailPrice\":{\"amount\":56000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":41499.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8dvfeuxxbm4r?pid=MOBEYGPZAHZQMCKZ&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":true,\"emiAvailable\":null,\"discountPercentage\":25.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Gold\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ2NUZGCHKN, MOBEYHZ2YAXZMF2J, MOBEYGPZAHZQMCKZ]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ254METXXB\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/x/x/b/apple-iphone-6-400x400-imaeynygkn5g4jzh.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/x/x/b/apple-iphone-6-200x200-imaeynygkn5g4jzh.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/x/x/b/apple-iphone-6-original-imaeynygkn5g4jzh.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/x/x/b/apple-iphone-6-800x800-imaeynygkn5g4jzh.jpeg\"},\"maximumRetailPrice\":{\"amount\":73000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":61990.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8ra5z7yx5c9j?pid=MOBEYHZ254METXXB&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":false,\"emiAvailable\":null,\"discountPercentage\":15.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Gold\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ254METXXB]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2VSVKHAZH\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"The bigger the better - the Apple iPhone 6 is an exemplar of this phrase. The meticulously crafted iPhone 6 is truly an epitome of great taste and elegance. Beautiful Unibody Design Extremely thin, the iPhone 6 flaunts a seamless design with the smooth blend of anodised aluminium, stainless steel and the curved, polished glass. Incredibly light, the beautifully crafted iPhone 6 feels great in your hands. Thanks to its innovative design, the iPhone 6 provides an intuitive experience and is extremely easy to use. Brilliant Display Featuring the thinnest and most advanced Multi-Touch display ever made, the Apple iPhone 6 promises a high-contrast output with incredible colors and brightness on its 4.7 inch Retina HD display. A resolution of 1334x750 pixels, clear wide-angle viewing and an improved polariser - the iPhone 6 truly offers a bigger and better display. Power-Packed Performance Thanks to the all-new A8 processor with 64-bit architecture and an advanced 20 nanometre process, the iPhone 6 delivers an incredibly powerful performance while being extremely efficient. Get up to 50x faster CPU performance and up to 84x faster GPU performance with the iPhone 6. M8 Motion Coprocessor & Sensors Improve your iPhone's power efficiency with the M8 Motion Coprocessor that continuously measures data from your iPhone's different sensors such as accelerometer, compass, gyroscope and the new barometer. Camera Photos or videos - there is nothing that can beat the iPhone 6's iSight camera. The iPhone 6's 8 MP iSight camera gets new features such as a new sensor with Focus Pixels, improved face detection and exposure control. Also, now you can take amazing 1080p HD videos with the world's most popular camera. Security Make life easier with the iPhone 6's breakthrough Touch ID technology. Now you can securely access your phone with your fingerprint - no more worries about forgetting your pass code ever again. Moreover, the iPhone 6 lets you use your fingerprint to securely make purchases on iTunes or the App Store. Operating System The iPhone 6 comes with the biggest iOS release ever - the iOS 8. Featuring new capabilities and features, the world's advanced mobile operating system - the iOS 8 - gives you an incredible experience on your iPhone 6. Connectivity Thanks to the advanced Wi-Fi support with fast wireless performance, you can keep up with the world around you easily. Moreover, the iPhone 6 comes with Bluetooth and 3G support. Battery Take advantage of all the features of your highly efficient Apple iPhone 6 which boasts of an amazing battery life with up to 14 hours of 3G talk time and up to 250 hours of standby.\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/a/z/h/apple-iphone-6-400x400-imaeynf5tzfkzaym.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/a/z/h/apple-iphone-6-200x200-imaeynf5tzfkzaym.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/a/z/h/apple-iphone-6-original-imaeynf5tzfkzaym.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/a/z/h/apple-iphone-6-800x800-imaeynf5tzfkzaym.jpeg\"},\"maximumRetailPrice\":{\"amount\":65000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":49800.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8ra6fzzme5sz?pid=MOBEYHZ2VSVKHAZH&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":true,\"emiAvailable\":null,\"discountPercentage\":23.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Gold\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2VRNZZ2J5\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"The bigger the better - the Apple iPhone 6 is an exemplar of this phrase. The meticulously crafted iPhone 6 is truly an epitome of great taste and elegance. Beautiful Unibody Design Extremely thin, the iPhone 6 flaunts a seamless design with the smooth blend of anodised aluminium, stainless steel and the curved, polished glass. Incredibly light, the beautifully crafted iPhone 6 feels great in your hands. Thanks to its innovative design, the iPhone 6 provides an intuitive experience and is extremely easy to use. Brilliant Display Featuring the thinnest and most advanced Multi-Touch display ever made, the Apple iPhone 6 promises a high-contrast output with incredible colors and brightness on its 4.7 inch Retina HD display. A resolution of 1334x750 pixels, clear wide-angle viewing and an improved polariser - the iPhone 6 truly offers a bigger and better display. Power-Packed Performance Thanks to the all-new A8 processor with 64-bit architecture and an advanced 20-nanometre process, the iPhone 6 delivers an incredibly powerful performance while being extremely efficient. Get up to 50x faster CPU performance and up to 84x faster GPU performance with the iPhone 6. M8 Motion Coprocessor & Sensors Improve your iPhone's power efficiency with the M8 Motion Coprocessor that continuously measures data from your iPhone's different sensors such as an accelerometer, a compass, a gyroscope and a barometer. Camera Photos or videos - there is nothing that can beat the iPhone 6's iSight camera. The iPhone 6's 8 MP iSight camera gets new features such as a new sensor with Focus Pixels, improved face detection and exposure control. Also, now you can take amazing 1080p HD videos with the world's most popular camera. Security Make life easier with the iPhone 6's breakthrough Touch ID technology. Now you can securely access your phone with your fingerprint - no more worries about forgetting your passcode ever again. Moreover, the iPhone 6 lets you use your fingerprint to securely make purchases on iTunes or the App Store. Operating System The iPhone 6 comes with the biggest iOS release ever - the iOS 8. Featuring new capabilities and features, the world's advanced mobile operating system - the iOS 8 - gives you an incredible experience on your iPhone 6. Connectivity Thanks to the advanced Wi-Fi support with fast wireless performance, you can keep up with the world around you easily. Moreover, the iPhone 6 comes with Bluetooth and 3G support. Battery Take advantage of all the features of your highly efficient Apple iPhone 6 which boasts of an amazing battery life with up to 14 hours of 3G talk time and up to 250 hours of standby.\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/2/j/5/apple-iphone-6-400x400-imaeyny5fy253xy4.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/2/j/5/apple-iphone-6-200x200-imaeyny5fy253xy4.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/2/j/5/apple-iphone-6-original-imaeyny5fy253xy4.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/2/j/5/apple-iphone-6-800x800-imaeyny5fy253xy4.jpeg\"},\"maximumRetailPrice\":{\"amount\":62000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":46493.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8ra6fzzme5sz?pid=MOBEYHZ2VRNZZ2J5&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":true,\"emiAvailable\":null,\"discountPercentage\":25.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Silver\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ2VSVKHAZH, MOBEYHZ2VRNZZ2J5]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2GY7HDHHG\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/h/h/g/apple-iphone-6-400x400-imaeyny5hqffnnbn.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/h/h/g/apple-iphone-6-200x200-imaeyny5hqffnnbn.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/h/h/g/apple-iphone-6-original-imaeyny5hqffnnbn.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/h/h/g/apple-iphone-6-800x800-imaeyny5hqffnnbn.jpeg\"},\"maximumRetailPrice\":{\"amount\":72000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":59999.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8ra5z7yx5c9j?pid=MOBEYHZ2GY7HDHHG&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":false,\"emiAvailable\":null,\"discountPercentage\":16.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Silver\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ254METXXB, MOBEYHZ2JHVFHFBG, MOBEYHZ2GY7HDHHG]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ28ZYTRJYM\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6 Plus\",\"productDescription\":\"\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-400x400-imaeymdqartzwz76.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-200x200-imaeymdqartzwz76.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-original-imaeymdqartzwz76.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/m/q/k/apple-iphone-6-plus-800x800-imaeymdqartzwz76.jpeg\"},\"maximumRetailPrice\":{\"amount\":72000.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":65999.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6-plus/p/itme7zfybgjccnzu?pid=MOBEYHZ28ZYTRJYM&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":false,\"emiAvailable\":null,\"discountPercentage\":8.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Silver\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYHZ2XVMKU4QN, MOBEYHZ2Z8N6RDFE, MOBEYHZ28ZYTRJYM]\",\"colorVariants\":\"[MOBEFJG74WYMR4ZJ, MOBEFJG77J8DD6Z4, MOBEFJG77RWZQ4YJ, MOBEFJG7FS3CPHQZ, MOBEFJG7KHUB4S7Y, MOBEFJG7Q6AAUVGM, MOBEFJG7RZNK3YNV, MOBEFJG7YA8Y89JD, MOBEFJG7ZZUGGTT9, MOBEYGPZZV9GQWZZ, MOBEYHZ2JRQ6UVYF, MOBEYHZ2RVZHCMQK, MOBEYHZ2SSKPYGRK, MOBEYHZ2VXZM8HZD, MOBEYHZ2XVMKU4QN, MOBEYHZ2YBFZTV3S, MOBEYHZ2Z8N6RDFE]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2NUZGCHKN\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"The bigger the better - the Apple iPhone 6 is an exemple of this phrase. The meticulously crafted iPhone 6 is truly an epitome of great taste and elegance. Beautiful Unibody Design Extremely thin, the iPhone 6 flaunts a seamless design with the smooth blend of anodised aluminium, stainless steel and the curved, polished glass. Incredibly light, the beautifully crafted iPhone 6 feels great in your hands. Thanks to its innovative design, the iPhone 6 provides an intuitive experience and is extremely easy to use. Brilliant Display Featuring the thinnest and most advanced Multi-Touch display ever made, the Apple iPhone 6 promises a high-contrast output with incredible colors and brightness on its 4.7 inch Retina HD display. A resolution of 1334x750 pixels, clear wide-angle viewing and an improved polariser - the iPhone 6 truly offers a bigger and better display. Power-Packed Performance Thanks to the all-new A8 processor with 64-bit architecture and an advanced 20 nanometre process, the iPhone 6 delivers an incredibly powerful performance while being extremely efficient. Get up to 50x faster CPU performance and up to 84x faster GPU performance with the iPhone 6. M8 Motion Coprocessor & Sensors Improve your iPhone's power efficiency with the M8 Motion Coprocessor that continuously measures data from your iPhone's different sensors such as accelerometer, compass, gyroscope and the new barometer. Camera Photos or videos - there is nothing that can beat the iPhone 6's iSight camera. The iPhone 6's 8 MP iSight camera gets new features such as a new sensor with Focus Pixels, improved face detection and exposure control. Also, now you can take amazing 1080p HD videos with the world's most popular camera. Security Make life easier with the iPhone 6's breakthrough Touch ID technology. Now you can securely access your phone with your fingerprint - no more worries about forgetting your pass code ever again. Moreover, the iPhone 6 lets you use your fingerprint to securely make purchases on iTunes or the App Store. Operating System The iPhone 6 comes with the biggest iOS release ever - the iOS 8. Featuring new capabilities and features, the world's advanced mobile operating system - the iOS 8 - gives you an incredible experience on your iPhone 6. Connectivity Thanks to the advanced Wi-Fi support with fast wireless performance, you can keep up with the world around you easily. Moreover, the iPhone 6 comes with Bluetooth and 3G support. Battery Take advantage of all the features of your highly efficient Apple iPhone 6 which boasts of an amazing battery life with up to 14 hours of 3G talk time and up to 250 hours of standby.\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-400x400-imaeyny5agaysfqg.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-200x200-imaeyny5agaysfqg.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-original-imaeyny5agaysfqg.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/h/k/n/apple-iphone-6-800x800-imaeyny5agaysfqg.jpeg\"},\"maximumRetailPrice\":{\"amount\":53500.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":33499.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8dvfeuxxbm4r?pid=MOBEYHZ2NUZGCHKN&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":true,\"emiAvailable\":null,\"discountPercentage\":37.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Silver\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYGPZAHZQMCKZ, MOBEYHZ2YAXZMF2J, MOBEYHZ2NUZGCHKN]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH, MOBEYHZ2YAXZMF2J]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null},{\"productBaseInfo\":{\"productIdentifier\":{\"productId\":\"MOBEYHZ2YAXZMF2J\",\"categoryPaths\":{\"categoryPath\":[[{\"title\":\"Mobiles>Handsets\"}]]}},\"productAttributes\":{\"title\":\"Apple iPhone 6\",\"productDescription\":\"The bigger the better - the Apple iPhone 6 is an exemplary of this phrase. The meticulously crafted iPhone 6 is truly an epitome of great taste and elegance. Beautiful Unibody Design Extremely thin, the iPhone 6 flaunts a seamless design with the smooth blend of anodised aluminium, stainless steel and the curved, polished glass. Incredibly light, the beautifully crafted iPhone 6 feels great in your hands. Thanks to its innovative design, the iPhone 6 provides an intuitive experience and is extremely easy to use. Brilliant Display Featuring the thinnest and most advanced Multi-Touch display ever made, the Apple iPhone 6 promises a high-contrast output with incredible colors and brightness on its 4.7 inch Retina HD display. A resolution of 1334 x 750 pixels, clear wide-angle viewing and an improved polariser - the iPhone 6 truly offers a bigger and better display. Power-Packed Performance Thanks to the all-new A8 processor with 64-bit architecture and an advanced 20 nanometre process, the iPhone 6 delivers an incredibly powerful performance while being extremely efficient. Get up to 50x faster CPU performance and up to 84x faster GPU performance with the iPhone 6. M8 Motion Coprocessor & Sensors Improve your iPhone's power efficiency with the M8 Motion Coprocessor that continuously measures data from your iPhone's different sensors such as accelerometer, compass, gyroscope and the new barometer. Camera Photos or videos - there is nothing that can beat the iPhone 6's iSight camera. The iPhone 6's 8 MP iSight camera gets new features such as a new sensor with Focus Pixels, improved face detection and exposure control. Also, now you can take amazing 1080p HD videos with the world's most popular camera. Security Make life easier with the iPhone 6's breakthrough Touch ID technology. Now you can securely access your phone with your fingerprint - no more worries about forgetting your pass code ever again. Moreover, the iPhone 6 lets you use your fingerprint to securely make purchases on iTunes or the App Store. Operating System The iPhone 6 comes with the biggest iOS release ever - the iOS 8. Featuring new capabilities and features, the world's advanced mobile operating system - the iOS 8 - gives you an incredible experience on your iPhone 6. Connectivity Thanks to the advanced Wi-Fi support with fast wireless performance, you can keep up with the world around you easily. Moreover, the iPhone 6 comes with Bluetooth and 3G support. Battery Take advantage of all the features of your highly efficient Apple iPhone 6 which boasts of an amazing battery life with up to 14 hours of 3G talk time and up to 250 hours of standby.\",\"imageUrls\":{\"400x400\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-400x400-imaeymdqs5gm5xkz.jpeg\",\"200x200\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-200x200-imaeymdqs5gm5xkz.jpeg\",\"unknown\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-original-imaeymdqs5gm5xkz.jpeg\",\"800x800\":\"http://img.fkcdn.com/image/mobile/f/2/j/apple-iphone-6-800x800-imaeymdqs5gm5xkz.jpeg\"},\"maximumRetailPrice\":{\"amount\":53500.0,\"currency\":\"INR\"},\"sellingPrice\":{\"amount\":33999.0,\"currency\":\"INR\"},\"productUrl\":\"http://dl.flipkart.com/dl/apple-iphone-6/p/itme8dvfeuxxbm4r?pid=MOBEYHZ2YAXZMF2J&affid=shariffaz\",\"productBrand\":\"Apple\",\"inStock\":true,\"isAvailable\":true,\"codAvailable\":true,\"emiAvailable\":null,\"discountPercentage\":36.0,\"cashBack\":null,\"offers\":[],\"size\":null,\"color\":\"Space Grey\",\"sizeUnit\":\"\",\"sizeVariants\":\"[MOBEYGPZAHZQMCKZ, MOBEYHZ2NUZGCHKN, MOBEYHZ2YAXZMF2J]\",\"colorVariants\":\"[MOBE4RW7WR5TWYQA, MOBEC894XYJZCNGR, MOBEFJG765FHFZJY, MOBEFJG7EKGHZEMN, MOBEFJG7FDGGMUZB, MOBEFJG7HWVD7AQG, MOBEFJG7MWPYV5DH, MOBEFJG7UDHGWBFJ, MOBEFJG7VKGJMZ5W, MOBEFJG7WZU9DZ8Y, MOBEYGPZAHZQMCKZ, MOBEYHZ254METXXB, MOBEYHZ28FRMNDCW, MOBEYHZ2GY7HDHHG, MOBEYHZ2JHVFHFBG, MOBEYHZ2NUZGCHKN, MOBEYHZ2VRNZZ2J5, MOBEYHZ2VSVKHAZH]\",\"styleCode\":null}},\"productShippingBaseInfo\":{\"shippingOptions\":null},\"offset\":null}]}";
    ArrayList<ItemContent> array = new ArrayList<ItemContent>();
    Button enter;
    EditText search;
    ProgressBar progressBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyCustomBaseAdapter adapter = new MyCustomBaseAdapter(this, array);
        list = (ListView) findViewById(R.id.list_view_product);
        search = (EditText) findViewById(R.id.search_text);
        enter = (Button) findViewById(R.id.button);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        list.setAdapter(adapter);
        final String[] searchString = new String[1];
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                searchString[0] = search.getText().toString();
                Context context = getApplicationContext();

                int duration = Toast.LENGTH_SHORT;
                String[] temp = search.getText().toString().split(" ");

                searchString[0]=temp[0];
                for(int i=1;i < temp.length;i++)
                {
                    searchString[0].concat("+");
                    searchString[0].concat(temp[i]);
                }
                new AsyncTask<Void, Void, Void>(){
                    @Override
                    protected Void doInBackground(Void... params) {
                        array.clear();
                        String jsonStr1 = fetch("https://aggregator-scripts-azharullah.c9users.io/flipkart.php?query=" + searchString[0]);
                        try {
                            getDataFromJson(jsonStr1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }.execute();
            }
        });

//        try {
//            getDataFromJson(jsonStr);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Object o = list.getItemAtPosition(position);
                Intent ourIntent;
                ItemContent fullObject = (ItemContent) o;
                Context context = getApplicationContext();
                Toast.makeText(context, "You have chosen: " + " " + fullObject.getTitle(), Toast.LENGTH_LONG).show();
//                ourIntent = new Intent(MainActivity.this, ProductView.class);
//                ourIntent.putExtra("product", fullObject);

            }
        });


    }
    String fetch(String addr){
        StringBuilder sb = new StringBuilder();

        try{
            URL url = new URL(addr);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            InputStream is = con.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            String txt;
            txt = dis.readLine();
            sb.append(txt);
            while(txt != null){
                Log.d("A", txt);
                txt = dis.readLine();
                sb.append(txt);
            }

        }
        catch (Exception e){
            Log.e("Error connection", e.getMessage());
        }

        return sb.toString();
    }

    private void getDataFromJson(String forecastJsonStr)
            throws JSONException {
        JSONObject forecastJson = new JSONObject(forecastJsonStr);
        JSONArray weatherArray = forecastJson.getJSONArray("productInfoList");


        for (int i = 0; i < weatherArray.length(); i++) {

            JSONObject productObject = weatherArray.getJSONObject(i);
            ItemContent it = new ItemContent();
            it.setTitle(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getString("title"));
            it.setImgid(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getJSONObject("imageUrls").getString("200x200"));
            it.setDescription(productObject.getJSONObject("productBaseInfo").getJSONObject("productAttributes").getString("title"));
            array.add(it);
        }
        return;
    }


}