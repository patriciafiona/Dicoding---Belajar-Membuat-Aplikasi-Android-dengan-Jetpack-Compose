package com.patriciafiona.subway.data.source

import com.patriciafiona.subway.R
import com.patriciafiona.subway.model.Category
import com.patriciafiona.subway.model.News
import com.patriciafiona.subway.model.ProductItem

object DataSource {

    fun promotions(): ArrayList<Int> = arrayListOf(
        R.drawable.promotion_01, R.drawable.promotion_02, R.drawable.promotion_03,
        R.drawable.promotion_04, R.drawable.promotion_05,
    )

    fun categories(): ArrayList<Category> = arrayListOf(
        Category(
            id = 1,
            name = "All Sandwiches",
            image = R.drawable.menu_all_sandwitch
        ),
        Category(
            id = 2,
            name = "Breakfast",
            image = R.drawable.menu_breakfast
        ),
        Category(
            id = 3,
            name = "Wraps",
            image = R.drawable.menu_wraps
        ),
        Category(
            id = 4,
            name = "Salads",
            image = R.drawable.menu_salads
        ),
        Category(
            id = 5,
            name = "Sides",
            image = R.drawable.menu_sides
        ),
        Category(
            id = 6,
            name = "Drinks",
            image = R.drawable.menu_drinks
        ),
    )

    fun news(): ArrayList<News> = arrayListOf(
        News(
            title = "Diet for GERD: Foods to Avoid in GERD – Dr. dr. Luciana Sutanto, MS, SpGK.",
            description =
                    "Gastroesophageal reflux disease (GERD) adalah asam lambung yang naik ke kerongkongan (saluran makan yang menghubungkan mulut " +
                    "dan lambung). Asam lambung selalu ada dalan jumlah normal sesuai dengan keadaan tubuh.  Jika jumlah asam lambung berlebihan " +
                    "maka dapat naik ke kerongkongan, yang disebut GERD, sehingga mengiritasi (melukai) lapisan permukaan kerongkongan, " +
                    "sehingga menimbulkan keluhan rasa panas di dada dan keluhan tidak nyaman lainnya. ",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/11/web-banner-1.jpg",
            news_url = "https://www.subway.co.id/diet-for-gerd-foods-to-avoid-in-gerd-dr-dr-luciana-sutanto-ms-spgk/"
        ),
        News(
            title = "Nutrition Tips to Lower Cholesterol – Dr. dr. Luciana Sutanto, MS, SpGK.",
            description = "Kolesterol diklasifikasikan sebagai kelompok lipid, seperti halnya lemak. Dalam tubuh kita, kolesterol membantu untuk\n" +
                    "membuat membran sel, hormon, dan vitamin D. Kolesterol darah kita berasal dari dua sumber yaitu. makanan yang kita makan dan produksi hati,\n" +
                    "hati membuat semua kolesterol untuk kebutuhan tubuh.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/08/homebanner-beef-sei-2.jpg",
            news_url = "https://www.subway.co.id/nutrition-tips-to-lower-cholesterol-dr-dr-luciana-sutanto-ms-spgk/"
        ),
        News(
            title = "Food rich in antioxidants for healthy lung – Dr. dr. Luciana Sutanto, MS, SpGK.",
            description = "Pencemaran udara dapat mengakibatkan gangguan kesehatan, gangguan yang terjadi di otak,  saluran cerna, sistem reproduksi, mata, " +
                    "tenggorokan, jantung dan paru.  Dampak yang ditimbulkan di antaranya ganguan pertumbuhan dan kecerdasan, mual, lesu, nafsu makan turun, " +
                    "gangguan kesuburan, iritasi dan peradangan mata, radang tenggorokan, kekurangan oksigen di darah serta flek pada paru, serta asma.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/07/1360x600.jpg",
            news_url = "https://www.subway.co.id/food-rich-in-antioxidants-for-healthy-lung-dr-dr-luciana-sutanto-ms-spgk/"
        ),
        News(
            title = "Seafood, a nutritious culinary – Dr. dr. Luciana Sutanto, MS, SpGK.",
            description = "Makanan laut atau segala bentuk biota laut yang dapat dikategorikan sebagai makanan, seperti udang, cumi-cumi, kepiting, " +
                    "kerang, ikan, gurita dll. Berdasarkan kandungan nutrisinya, makanan laut dikelompokkan sebagai sumber protein, dengan kandungan " +
                    "protein sekitar 10 gram per 50 gram makanan, dan 6 gram lemak, berbagai vitamin dan mineral dan juga menyediakan sekitar 95 kalori energi. " +
                    "Mengenai manfaatnya, Organisasi Kesehatan Dunia (WHO) dan Kementerian Kesehatan RI merekomendasikan konsumsi ikan dua kali seminggu.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/05/WhatsApp-Image-2022-05-13-at-8.58.06-PM.jpeg",
            news_url = "https://www.subway.co.id/seafood-a-nutritious-culinary-dr-dr-luciana-sutanto-ms-spgk/"
        ),
        News(
            title = "How To Eat Within the Healthy Calorie Range During Fasting – Dr. dr. Luciana Sutanto, MS, SpGK.",
            description = "Ramadan is coming soon. People who are celebrating  will refrain from eating, drinking, and other activities. " +
                    "Some people hope by fasting, apart from worshiping, they will also stay healthy and maintain a healthy weight.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/11/Must-try-items-home-banner.jpg",
            news_url = "https://www.subway.co.id/how-to-eat-within-the-healthy-calorie-range-during-fasting/"
        )
    )

    fun products(): ArrayList<ProductItem> = arrayListOf(
        ProductItem(
            id = 1,
            title = "Veggie Delite",
            description = "A delightfully fresh combination of juicy lettuce, tomatoes, green peppers, onions and your choice of condiments served on freshly baked bread. It’s a scrumptiously crunchy sandwich.\n" +
                    "\n" +
                    "Kombinasi kesegaran sempurna dari selada, tomat, paprika hijau, bawang Bombay dan juga pilihan saus mu yang disajikan dengan roti yang baru dipanggang. Sungguh merupakan sandwich yang nikmat dan renyah!",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/veggie-1.png",
            category_id = 1,
            price = 25000.0,
            web_url = "https://www.subway.co.id/product/veggie-delite/"
        ),
        ProductItem(
            id = 2,
            title = "Spicy Italian",
            description = "Spice up your life with some real flavor. Served on freshly baked bread and toasted to perfection, the Spicy Italian sandwich features spicy pepperoni and delicious slices of salami. For a more personalized taste, add fresh peppers, oil, vinegar or anything else to suit your liking.\n" +
                    "\n" +
                    "Ini dia menu yang buat hidup mu semakin berwarna! Spicy Italian terdiri dari pepperoni dan irisan salami yang di sajikan dengan roti segar yang baru dipanggang setiap hari. Tambahkan juga pelengkap lainnya sesuai selera mu.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/spicy-italian-front.png",
            category_id = 1,
            price = 45000.0,
             web_url = "https://www.subway.co.id/product/spicy-italian/"
        ),
        ProductItem(
            id = 3,
            title = "Chicken Teriyaki",
            description = "An Asian classic gourmet made with a flavorful blend of tender chicken pieces dressed lightly with teriyaki sauce. Served hot and topped with your choice of crisp vegetables and condiments on freshly baked bread.\n" +
                    "\n" +
                    "Hidangan khas Asia, dengan potongan daging ayam lembut dibalut dengan saus teriyaki lezat, disajikan dengan sayur segar dan saus pilihanmu diatas roti yang dipanggang setiap hari nya.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/chicken-teriyaki-front-e1633678475910.png",
            category_id = 1,
            price = 37500.0,
             web_url = "https://www.subway.co.id/product/chicken-teriyaki/"
        ),
        ProductItem(
            id = 4,
            title = "Chicken Slice",
            description = "For those who prefer lighter meat, enjoy a Savory Chicken Sub now. Lean and tender, gourmet style sliced chicken with your choice of crisp vegetables and condiments served on freshly baked bread.\n" +
                    "\n" +
                    "Untuk yang lebih menyukai irisan tipis daging ayam yang gurih dan lembut, disajikan dengan sayur segar dan saus pilihanmu diatas roti yang dipanggang setiap hari nya.",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/ham-front.png",
            category_id = 1,
            price = 32000.0,
             web_url = "https://www.subway.co.id/product/chicken-ham/"
        ),
        ProductItem(
            id = 5,
            title = "Tuna Mayo",
            description = "Another gift from the sea of simple yet sumptuous Tuna is blessed " +
                    "with creamy mayonnaise and making it a lovely blend of the world’s favorite " +
                    "comfort foods. The Tuna sub is available with your choice of crisp " +
                    "vegetables and condiments and served on freshly baked bread.\n" +
                    "\n" +
                    "Nikmati kelezatan daging tuna dengan lembutnya krim mayo yang menjadikannya " +
                    "perpaduan terbaik dan menjadi makanan pilihan nomor 1 di dunia. Tuna sub " +
                    "disajikan juga dengan berbagai pilihan sayuran segar dan roti yang baru " +
                    "dipanggang." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/tuna-front.png",
            category_id = 1,
            price = 37500.0,
            web_url = "https://www.subway.co.id/product/tuna_mayo/"
        ),
        ProductItem(
            id = 6,
            title = "Italian B.M.T",
            description = "An old world favorite sandwich that is made up of sliced salami, " +
                    "pepperoni , sliced chicken. Some say B.M.T.™ stands for biggest, meatiest, " +
                    "tastiest\n" +
                    "\n" +
                    "Sandwich favorit di dunia yang terdiri dari irisan salami, pepperoni, dan " +
                    "irisan daging ayam. Beberapa orang bilang B.M.T™ adalah singkatan dari " +
                    "biggest (besar), meatiest (gemuk), tastiest (dan enak)." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Italian-BMT-Front.png",
            category_id = 1,
            price = 45000.0,
            web_url = "https://www.subway.co.id/product/italian-b-m-t/"
        ),
        ProductItem(
            id = 7,
            title = "Egg Mayo",
            description = "A simple recipe anyone will love with a thick spread of chopped up " +
                    "boiled egg mixed with creamy rich mayonnaise.\n" +
                    "\n" +
                    "Resep sederhana yang disukai banyak orang dengan potongan telur yang tebal, " +
                    "bercampur dengan krim mayonnaise yang lembut." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/egg-mayo.png",
            category_id = 1,
            price = 32000.0,
             web_url = "https://www.subway.co.id/product/egg-mayo/"
        ),
        ProductItem(
            id = 8,
            title = "Steak & Cheese",
            description = "For a sinful delight, the Cheese Steak features mouth-watering slices " +
                    "of tender steak with sautéed onions and green peppers topped with melted " +
                    "cheese. It’s served hot with your choice of crisp vegetables and condiments " +
                    "on freshly baked bread.\n" +
                    "\n" +
                    "Untuk kenikmatan tiada tara, Steak & Cheese terdiri dari potong daging " +
                    "steak lembut, paprika hijau dan juga keju yang dilelehkan. Disajikan " +
                    "secara hangat dengan berbagai pilihan sayuran segar dan roti yang baru " +
                    "dipanggang." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/steak_cheese-front.png",
            category_id = 1,
            price = 57000.0,
            web_url = "https://www.subway.co.id/product/steak-cheese/"
        ),
        ProductItem(
            id = 9,
            title = "BBQ Chicken",
            description = "The New BBQ Chicken Sandwich consist of tender chicken strips paired " +
                    "with sweet and tangy St.louis style BBQ sauce, fresh lettuce,tomatoes, " +
                    "red onions and pickles on your choice of toasted bread.\n" +
                    "\n" +
                    "Nikmati kelembutan daging ayam yang dibalut dengan manis dan gurih nya " +
                    "saus BBQ. Disajikan dengan salada segar, tomat, bawang Bombay, dan pickles " +
                    "di dalam roti yang baru dipanggang." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Untitled-design-2.png",
            category_id = 1,
            price = 37500.0,
             web_url = "https://www.subway.co.id/product/bbq-chicken/"
        ),
        ProductItem(
            id = 10,
            title = "Roast Chicken",
            description = "Lightly seasoned chicken that is roasted to perfection, gets added " +
                    "flavor when served with a choice of crisp veggies on freshly baked bread.\n" +
                    "\n" +
                    "Ayam berbumbu yang di panggang sempurna, disajikan dengan sayuran segar " +
                    "dan roti yang baru dipanggang." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/roast-chicken-front.png",
            category_id = 1,
            price = 37500.0,
             web_url = "https://www.subway.co.id/product/roast-chicken/"
        ),
        ProductItem(
            id = 11,
            title = "Roast Beef",
            description = "A delicious slice of meats that makes your day nice. It’s served hot " +
                    "with your choice of crisp vegetables and condiments on freshly baked bread.\n" +
                    "\n" +
                    "Kelezatan dari irisan daging sapi untuk cerahkan harimu. Disajikan secara " +
                    "hangat dengan berbagai pilihan sayuran segar dan roti yang baru dipanggang." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/01/Roast-Beef.png",
            category_id = 1,
            price = 57000.0,
             web_url = "https://www.subway.co.id/product/roast-beef/"
        ),
        ProductItem(
            id = 12,
            title = "Shrimp Avocado",
            description = "Menu favorit sepanjang masa, dengan daging udang segar, ditambah " +
                    "pasta alpukat  dan lemon yang dipadukan dengan creamy mayonaise sehingga" +
                    " menjadikan menu ini mendapat rekomendasi tertinggi dari Subway." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/10/Shrimp-Avocado-1.png",
            category_id = 1,
            price = 57000.0,
             web_url = "https://www.subway.co.id/product/shrimp-avocado/"
        ),
        ProductItem(
            id = 13,
            title = "Meatball Marinara",
            description = "Juicy meatball submerge with tempting marinara sauce. Surely you " +
                    "can not resist this Subway classic.\n" +
                    "\n" +
                    "Bola-bola daging yang juicy dengan saus marinara yang lezat. Dipastikan " +
                    "kamu tidak dapat menolak kelezatan dari menu klasik Subway." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2022/01/Meatball-Marinara-2.png",
            category_id = 1,
            price = 57000.0,
             web_url = "https://www.subway.co.id/product/meatball-marinara/"
        ),
        ProductItem(
            id = 14,
            title = "Chicken Slice & Egg",
            description = "Rise and shine to a SUBWAY® Breakfast. Let your hunger pangs and " +
                    "taste buds decide from a spread of cheese, chicken slice, breakfast strips " +
                    "or tuna (all served with egg). So start the day fresh with a SUBWAY® sandwich.\n" +
                    "\n" +
                    "Waktu nya sarapan dengan SUBWAY®! Nikmati kelezatan santap pagi dengan keju, " +
                    "potongan ayam, breakfast strips atau tuna (semua disajikan dengan telur). " +
                    "Awali hari mu dengan sarapan bersama sandwich dari SUBWAY®." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken-Ham-Egg.png",
            category_id = 2,
            price = 27000.0,
             web_url = "https://www.subway.co.id/product/chicken-slice-egg/"
        ),
        ProductItem(
            id = 15,
            title = "Tuna & Egg",
            description = "Rise and shine to a SUBWAY® Breakfast. Let your hunger pangs and taste" +
                    " buds decide from a spread of cheese, chicken slice, breakfast strips or " +
                    "tuna (all served with egg). So start the day fresh with a SUBWAY® sandwich.\n" +
                    "\n" +
                    "Waktu nya sarapan dengan SUBWAY®! Nikmati kelezatan santap pagi dengan " +
                    "keju, potongan ayam, breakfast strips atau tuna (semua disajikan dengan " +
                    "telur). Awali hari mu dengan sarapan bersama sandwich dari SUBWAY®." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Tuna-Egg.png",
            category_id = 2,
            price = 35000.0,
             web_url = "https://www.subway.co.id/product/tuna-egg/"
        ),
        ProductItem(
            id = 16,
            title = "Cheese & Egg",
            description = "Rise and shine to a SUBWAY® Breakfast. Let your hunger pangs and " +
                    "taste buds decide from a spread of cheese, chicken slice, breakfast strips" +
                    " or tuna (all served with egg). So start the day fresh with a SUBWAY® " +
                    "sandwich.\n" +
                    "\n" +
                    "Waktu nya sarapan dengan SUBWAY®! Nikmati kelezatan santap pagi dengan keju, " +
                    "potongan ayam, breakfast strips atau tuna (semua disajikan dengan telur). " +
                    "Awali hari mu dengan sarapan bersama sandwich dari SUBWAY®." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Cheese-Egg.png",
            category_id = 2,
            price = 24000.0,
             web_url = "https://www.subway.co.id/product/cheese-egg/"
        ),
        ProductItem(
            id = 17,
            title = "Breakfast Strips & Egg",
            description = "Rise and shine to a SUBWAY® Breakfast. Let your hunger pangs and taste " +
                    "buds decide from a spread of cheese, chicken slice, breakfast strips or tuna " +
                    "(all served with egg). So start the day fresh with a SUBWAY® sandwich.\n" +
                    "\n" +
                    "Waktu nya sarapan dengan SUBWAY®! Nikmati kelezatan santap pagi dengan keju," +
                    " potongan ayam, breakfast strips atau tuna (semua disajikan dengan telur). " +
                    "Awali hari mu dengan sarapan bersama sandwich dari SUBWAY®." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Breakfast-Strip-Egg.png",
            category_id = 2,
            price = 27000.0,
             web_url = "https://www.subway.co.id/product/breakfast-strip-egg/"
        ),
        ProductItem(
            id = 18,
            title = "BBQ Chicken",
            description = "It has a great serving of proteins in a soft flatbread (wrap). Then it " +
                    "gets topped with any crunchy veggies you want.\n" +
                    "\n" +
                    "Terdiri dari menu dengan protein yang di pilih lalu dibungkus dengan roti " +
                    "tipis dan disajikan dengan berbagai sayuran segar pilihanmu." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/BBQ_Chicken_wrap_594x334.jpg",
            category_id = 3,
            price = 40500.0,
             web_url = "https://www.subway.co.id/product/bbq-chicken-wraps/"
        ),
        ProductItem(
            id = 19,
            title = "Chicken Slice",
            description = "It has a great serving of proteins in a soft flatbread (wrap). " +
                    "Then it gets topped with any crunchy veggies you want.\n" +
                    "\n" +
                    "Terdiri dari menu dengan protein yang di pilih lalu dibungkus dengan " +
                    "roti tipis dan disajikan dengan berbagai sayuran segar pilihanmu." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken_Strip_Wrap_594x334.jpg",
            category_id = 3,
            price = 35000.0,
             web_url = "https://www.subway.co.id/product/chicken-slice-wraps/"
        ),
        ProductItem(
            id = 20,
            title = "Chicken Teriyaki",
            description = "It has a great serving of proteins in a soft flatbread (wrap)." +
                    " Then it gets topped with any crunchy veggies you want.\n" +
                    "\n" +
                    "Terdiri dari menu dengan protein yang di pilih lalu dibungkus dengan roti " +
                    "tipis dan disajikan dengan berbagai sayuran segar pilihanmu." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken_Teriyaki_Wrap_594x334.jpg",
            category_id = 3,
            price = 40500.0,
            web_url = "https://www.subway.co.id/product/chicken-teriyaki-wraps/"
        ),
        ProductItem(
            id = 21,
            title = "Italian B.M.T",
            description = "It has a great serving of proteins in a soft flatbread (wrap). " +
                    "Then it gets topped with any crunchy veggies you want.\n" +
                    "\n" +
                    "Terdiri dari menu dengan protein yang di pilih lalu dibungkus dengan roti " +
                    "tipis dan disajikan dengan berbagai sayuran segar pilihanmu." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Italian_BMT_Wrap_594x334.png",
            category_id = 3,
            price = 48000.0,
            web_url = "https://www.subway.co.id/product/italian-b-m-t-wraps/"
        ),
        ProductItem(
            id = 22,
            title = "BBQ Chicken",
            description = "Turn your favorite SUBWAY® meats and veggies into a mouth-watering " +
                    "salad made just the way you want it. Top it with ranch dressing or light " +
                    "Italian for a flavourful, satisfying meal.\n" +
                    "\n" +
                    "Ubah menu sandwich SUBWAY® menjadi salad yang menggugah selera dengan " +
                    "tambahan sayur segar! Jangan lupa tuang saus favorit-mu dan jadikan salad " +
                    "ini hidangan yang lezat dan memuaskan." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Buffalo_Chicken_Salad_JPEG_594x334.jpg",
            category_id = 4,
            price = 54500.0,
            web_url = "https://www.subway.co.id/product/bbq-chicken-salad/"
        ),
        ProductItem(
            id = 23,
            title = "Chicken slice",
            description = "Turn your favorite SUBWAY® meats and veggies into a mouth-watering " +
                    "salad made just the way you want it. Top it with ranch dressing or light " +
                    "Italian for a flavourful, satisfying meal.\n" +
                    "\n" +
                    "Ubah menu sandwich SUBWAY® menjadi salad yang menggugah selera dengan " +
                    "tambahan sayur segar! Jangan lupa tuang saus favorit-mu dan jadikan salad " +
                    "ini hidangan yang lezat dan memuaskan." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken_Roasted_Salad_594x334.jpg",
            category_id = 4,
            price = 49000.0,
            web_url = "https://www.subway.co.id/product/chicken-slice-salad/"
        ),
        ProductItem(
            id = 24,
            title = "Chicken Teriyaki",
            description = "Turn your favorite SUBWAY® meats and veggies into a mouth-watering " +
                    "salad made just the way you want it. Top it with ranch dressing or light " +
                    "Italian for a flavourful, satisfying meal.\n" +
                    "\n" +
                    "Ubah menu sandwich SUBWAY® menjadi salad yang menggugah selera dengan " +
                    "tambahan sayur segar! Jangan lupa tuang saus favorit-mu dan jadikan salad " +
                    "ini hidangan yang lezat dan memuaskan." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken_Teriyaki_salad_594x334.jpg",
            category_id = 4,
            price = 49000.0,
            web_url = "https://www.subway.co.id/product/chicken-teriyaki-salad/"
        ),
        ProductItem(
            id = 25,
            title = "Italian B.M.T",
            description = "Turn your favorite SUBWAY® meats and veggies into a mouth-watering " +
                    "salad made just the way you want it. Top it with ranch dressing or light " +
                    "Italian for a flavourful, satisfying meal.\n" +
                    "\n" +
                    "Ubah menu sandwich SUBWAY® menjadi salad yang menggugah selera dengan " +
                    "tambahan sayur segar! Jangan lupa tuang saus favorit-mu dan jadikan salad " +
                    "ini hidangan yang lezat dan memuaskan." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Italian_BMT_Salad_594x334.jpg",
            category_id = 4,
            price = 62000.0,
            web_url = "https://www.subway.co.id/product/italian-b-m-t-salad/"
        ),
        ProductItem(
            id = 26,
            title = "Steak & Cheese",
            description = "Turn your favorite SUBWAY® meats and veggies into a mouth-watering " +
                    "salad made just the way you want it. Top it with ranch dressing or light " +
                    "Italian for a flavourful, satisfying meal.\n" +
                    "\n" +
                    "Ubah menu sandwich SUBWAY® menjadi salad yang menggugah selera dengan " +
                    "tambahan sayur segar! Jangan lupa tuang saus favorit-mu dan jadikan salad " +
                    "ini hidangan yang lezat dan memuaskan." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chipotle_Steak_Melt_Salads_594x334.jpg",
            category_id = 4,
            price = 74000.0,
            web_url = "https://www.subway.co.id/product/steak_cheese_salad/"
        ),
        ProductItem(
            id = 27,
            title = "Oatmeal Raisin Cookies",
            description = "As delicious as our sandwiches are, they are even better when paired " +
                    "with the perfect side and drink or even adding a little something extra. " +
                    "With such a variety to choose from, there’s truly something for every taste.\n" +
                    "\n" +
                    "Sama lezat nya dengan Sandwich kami, bahkan lebih baik jika dipasangkan " +
                    "dengan minuman. Terdapat berbagai pilihan Cookie yang lezat untuk di coba!" +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/png-transparent-oatmeal-raisin-cookies-chocolate-chip-cookie-peanut-butter-cookie-schmackary-s-baking-biscuit.png",
            category_id = 5,
            price = 19500.0,
            web_url = "https://www.subway.co.id/product/oatmeal-raisin-cookies/"
        ),
        ProductItem(
            id = 28,
            title = "Chocolate Chip Cookie",
            description = "As delicious as our sandwiches are, they are even better when paired " +
                    "with the perfect side and drink or even adding a little something extra. " +
                    "With such a variety to choose from, there’s truly something for every taste.\n" +
                    "\n" +
                    "Sama lezat nya dengan Sandwich kami, bahkan lebih baik jika dipasangkan " +
                    "dengan minuman. Terdapat berbagai pilihan Cookie yang lezat untuk di coba!" +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/RPLC-chocolatechipcookie_PR_PR-1.png",
            category_id = 5,
            price = 19500.0,
            web_url = "https://www.subway.co.id/product/chocolate-chip-cookie/"
        ),
        ProductItem(
            id = 29,
            title = "Double Chocolate Chip Cookie",
            description = "As delicious as our sandwiches are, they are even better when paired " +
                    "with the perfect side and drink or even adding a little something extra. " +
                    "With such a variety to choose from, there’s truly something for every taste.\n" +
                    "\n" +
                    "Sama lezat nya dengan Sandwich kami, bahkan lebih baik jika dipasangkan " +
                    "dengan minuman. Terdapat berbagai pilihan Cookie yang lezat untuk di coba!" +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/RPLC-doublechocolatechipcookie-1.png",
            category_id = 5,
            price = 19500.0,
            web_url = "https://www.subway.co.id/product/double-chocolate-chip-cookie/"
        ),
        ProductItem(
            id = 30,
            title = "Chicken Slice & Cheese",
            description = "Want to eat something light but filling? Pepperoni Toasty is your " +
                    "best bet! With pepperoni slices and cheese, your tummy will be satisfied\n" +
                    "\n" +
                    "Ingin makan sesuatu yang ringan tapi tetap kenyang? Chicken Slice Toasty " +
                    "adalah jawabannya! Dengan daging ayam lembut dan lelehan kejunya bakal " +
                    "bikin kamu ketagihan!" +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Chicken-Ham-_-Cheese-Toastie.png",
            category_id = 5,
            price = 17500.0,
             web_url = "https://www.subway.co.id/product/chicken-slice-cheese/"
        ),
        ProductItem(
            id = 31,
            title = "Egg Mayo Toasty",
            description = "Want to eat something light but filling? Egg Mayo Toasty is your best " +
                    "bet! Your tummy will be satisfied.\n" +
                    "\n" +
                    "Ingin makan sesuatu yang ringan tapi tetap kenyang? Egg Mayo Toasty adalah " +
                    "jawabannya! Dengan potongan telur yang tebal, bercampur dengan krim " +
                    "mayonnaise yang lembut, bakal bikin kamu ketagihan!" +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/09/Egg-Mayo-Toastie.png",
            category_id = 5,
            price = 17500.0,
            web_url = "https://www.subway.co.id/product/egg-mayo-toasty/"
        ),
        ProductItem(
            id = 32,
            title = "Mushroom Soup",
            description = "Complete your delicious Sandwich with drinks and snacks. With a " +
                    "variety of choices such as delicious cookies, savory toasties and " +
                    "refreshing drinks. All ready to make your day more cheerful.\n" +
                    "\n" +
                    "Sempurnakan Sandwich-mu yang lezat dengan minuman dan cemilan. Dengan " +
                    "berbagai macam pilihan seperti cookies yang nikmat, toasties yang gurih " +
                    "dan minuman yang segar. Semua siap membuat harimu semakin ceria." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/mushroom-soup.png",
            category_id = 5,
            price = 29500.0,
            web_url = "https://www.subway.co.id/product/mushroom-soup/"
        ),
        ProductItem(
            id = 33,
            title = "Aqua 300ml",
            description = "Complete your delicious Sandwich with drinks and snacks. " +
                    "With a variety of choices such as delicious cookies, savory " +
                    "toasties and refreshing drinks. All ready to make your day more cheerful.\n" +
                    "\n" +
                    "Sempurnakan Sandwich-mu yang lezat dengan minuman dan cemilan. " +
                    "Dengan berbagai macam pilihan seperti cookies yang nikmat, toasties " +
                    "yang gurih dan minuman yang segar. Semua siap membuat harimu semakin ceria." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/Aqua-300ml.png",
            category_id = 6,
            price = 9000.0,
            web_url = "https://www.subway.co.id/product/aqua-300ml/"
        ),
        ProductItem(
            id = 34,
            title = "Carbonated Drinks 16oz",
            description = "Complete your delicious Sandwich with drinks and snacks. " +
                    "With a variety of choices such as delicious cookies, savory " +
                    "toasties and refreshing drinks. All ready to make your day more cheerful.\n" +
                    "\n" +
                    "Sempurnakan Sandwich-mu yang lezat dengan minuman dan cemilan. " +
                    "Dengan berbagai macam pilihan seperti cookies yang nikmat, toasties " +
                    "yang gurih dan minuman yang segar. Semua siap membuat harimu semakin ceria." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/09/carbonated-drinks.png",
            category_id = 6,
            price = 19000.0,
            web_url = "https://www.subway.co.id/product/carbonated-drinks/"
        ),
        ProductItem(
            id = 35,
            title = "Coffee Latte 8oz",
            description = "Complete your delicious Sandwich with drinks and snacks. " +
                    "With a variety of choices such as delicious cookies, savory " +
                    "toasties and refreshing drinks. All ready to make your day more cheerful.\n" +
                    "\n" +
                    "Sempurnakan Sandwich-mu yang lezat dengan minuman dan cemilan. " +
                    "Dengan berbagai macam pilihan seperti cookies yang nikmat, toasties " +
                    "yang gurih dan minuman yang segar. Semua siap membuat harimu semakin ceria." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/coffee-1.png",
            category_id = 6,
            price = 25000.0,
            web_url = "https://www.subway.co.id/product/coffee/"
        ),
        ProductItem(
            id = 36,
            title = "Minute maid Pulpy orange",
            description = "Complete your delicious Sandwich with drinks and snacks. " +
                    "With a variety of choices such as delicious cookies, savory " +
                    "toasties and refreshing drinks. All ready to make your day more cheerful.\n" +
                    "\n" +
                    "Sempurnakan Sandwich-mu yang lezat dengan minuman dan cemilan. " +
                    "Dengan berbagai macam pilihan seperti cookies yang nikmat, toasties " +
                    "yang gurih dan minuman yang segar. Semua siap membuat harimu semakin ceria." +
                    "",
            image_url = "https://www.subway.co.id/wp-content/uploads/2021/08/minutemadepulpyorange.png",
            category_id = 6,
            price = 17000.0,
            web_url = "https://www.subway.co.id/product/minute-maid-pulpy-orange/"
        ),
    )
}