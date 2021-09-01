package java.time.format;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

class ZoneName {
  private static final String[] zidMap = { 
      "Pacific/Rarotonga", "Cook", "Pacific/Rarotonga", "Europe/Tirane", "Europe_Central", "Europe/Paris", "America/Recife", "Brasilia", "America/Sao_Paulo", "America/Argentina/San_Juan", 
      "Argentina", "America/Buenos_Aires", "Asia/Kolkata", "India", "Asia/Calcutta", "America/Guayaquil", "Ecuador", "America/Guayaquil", "Europe/Samara", "Moscow", 
      "Europe/Moscow", "Indian/Antananarivo", "Africa_Eastern", "Africa/Nairobi", "America/Santa_Isabel", "America_Pacific", "America/Los_Angeles", "America/Montserrat", "Atlantic", "America/Halifax", 
      "Pacific/Port_Moresby", "Papua_New_Guinea", "Pacific/Port_Moresby", "Europe/Paris", "Europe_Central", "Europe/Paris", "America/Argentina/Salta", "Argentina", "America/Buenos_Aires", "Asia/Omsk", 
      "Omsk", "Asia/Omsk", "Africa/Ceuta", "Europe_Central", "Europe/Paris", "America/Argentina/San_Luis", "Argentina_Western", "America/Argentina/San_Luis", "America/Atikokan", "America_Eastern", 
      "America/New_York", "Asia/Vladivostok", "Vladivostok", "Asia/Vladivostok", "America/Argentina/Jujuy", "Argentina", "America/Buenos_Aires", "Asia/Almaty", "Kazakhstan_Eastern", "Asia/Almaty", 
      "Atlantic/Canary", "Europe_Western", "Atlantic/Canary", "Asia/Bangkok", "Indochina", "Asia/Saigon", "America/Caracas", "Venezuela", "America/Caracas", "Australia/Hobart", 
      "Australia_Eastern", "Australia/Sydney", "America/Havana", "Cuba", "America/Havana", "Africa/Malabo", "Africa_Western", "Africa/Lagos", "Australia/Lord_Howe", "Lord_Howe", 
      "Australia/Lord_Howe", "Pacific/Fakaofo", "Tokelau", "Pacific/Fakaofo", "America/Matamoros", "America_Central", "America/Chicago", "America/Guadeloupe", "Atlantic", "America/Halifax", 
      "Europe/Helsinki", "Europe_Eastern", "Europe/Bucharest", "Asia/Calcutta", "India", "Asia/Calcutta", "Africa/Kinshasa", "Africa_Western", "Africa/Lagos", "America/Miquelon", 
      "Pierre_Miquelon", "America/Miquelon", "Europe/Athens", "Europe_Eastern", "Europe/Bucharest", "Asia/Novosibirsk", "Novosibirsk", "Asia/Novosibirsk", "Indian/Cocos", "Cocos", 
      "Indian/Cocos", "Africa/Bujumbura", "Africa_Central", "Africa/Maputo", "Europe/Mariehamn", "Europe_Eastern", "Europe/Bucharest", "America/Winnipeg", "America_Central", "America/Chicago", 
      "America/Buenos_Aires", "Argentina", "America/Buenos_Aires", "America/Yellowknife", "America_Mountain", "America/Denver", "Pacific/Midway", "Samoa", "Pacific/Apia", "Africa/Dar_es_Salaam", 
      "Africa_Eastern", "Africa/Nairobi", "Pacific/Tahiti", "Tahiti", "Pacific/Tahiti", "Asia/Gaza", "Europe_Eastern", "Europe/Bucharest", "Australia/Lindeman", "Australia_Eastern", 
      "Australia/Sydney", "Europe/Kaliningrad", "Europe_Eastern", "Europe/Bucharest", "Europe/Bucharest", "Europe_Eastern", "Europe/Bucharest", "America/Lower_Princes", "Atlantic", "America/Halifax", 
      "Pacific/Chuuk", "Truk", "Pacific/Truk", "America/Anchorage", "Alaska", "America/Juneau", "America/Rankin_Inlet", "America_Central", "America/Chicago", "America/Marigot", 
      "Atlantic", "America/Halifax", "Africa/Juba", "Africa_Eastern", "Africa/Nairobi", "Africa/Algiers", "Europe_Central", "Europe/Paris", "Europe/Kiev", "Europe_Eastern", 
      "Europe/Bucharest", "America/Santarem", "Brasilia", "America/Sao_Paulo", "Africa/Brazzaville", "Africa_Western", "Africa/Lagos", "Asia/Choibalsan", "Choibalsan", "Asia/Choibalsan", 
      "Indian/Christmas", "Christmas", "Indian/Christmas", "America/Nassau", "America_Eastern", "America/New_York", "Africa/Tunis", "Europe_Central", "Europe/Paris", "Pacific/Noumea", 
      "New_Caledonia", "Pacific/Noumea", "Africa/El_Aaiun", "Europe_Western", "Atlantic/Canary", "Europe/Sarajevo", "Europe_Central", "Europe/Paris", "America/Campo_Grande", "Amazon", 
      "America/Manaus", "America/Puerto_Rico", "Atlantic", "America/Halifax", "Antarctica/Mawson", "Mawson", "Antarctica/Mawson", "Pacific/Galapagos", "Galapagos", "Pacific/Galapagos", 
      "Asia/Tehran", "Iran", "Asia/Tehran", "America/Port-au-Prince", "America_Eastern", "America/New_York", "America/Scoresbysund", "Greenland_Eastern", "America/Scoresbysund", "Africa/Harare", 
      "Africa_Central", "Africa/Maputo", "America/Dominica", "Atlantic", "America/Halifax", "Europe/Chisinau", "Europe_Eastern", "Europe/Bucharest", "America/Chihuahua", "America_Mountain", 
      "America/Denver", "America/La_Paz", "Bolivia", "America/La_Paz", "Indian/Chagos", "Indian_Ocean", "Indian/Chagos", "Australia/Broken_Hill", "Australia_Central", "Australia/Adelaide", 
      "America/Grenada", "Atlantic", "America/Halifax", "America/North_Dakota/New_Salem", "America_Central", "America/Chicago", "Pacific/Majuro", "Marshall_Islands", "Pacific/Majuro", "Australia/Adelaide", 
      "Australia_Central", "Australia/Adelaide", "Europe/Warsaw", "Europe_Central", "Europe/Paris", "Europe/Vienna", "Europe_Central", "Europe/Paris", "Atlantic/Cape_Verde", "Cape_Verde", 
      "Atlantic/Cape_Verde", "America/Mendoza", "Argentina", "America/Buenos_Aires", "Pacific/Gambier", "Gambier", "Pacific/Gambier", "Europe/Istanbul", "Europe_Eastern", "Europe/Bucharest", 
      "America/Kentucky/Monticello", "America_Eastern", "America/New_York", "America/Chicago", "America_Central", "America/Chicago", "Asia/Ulaanbaatar", "Mongolia", "Asia/Ulaanbaatar", "Indian/Maldives", 
      "Maldives", "Indian/Maldives", "America/Mexico_City", "America_Central", "America/Chicago", "Africa/Asmara", "Africa_Eastern", "Africa/Nairobi", "Asia/Chongqing", "China", 
      "Asia/Shanghai", "America/Argentina/La_Rioja", "Argentina", "America/Buenos_Aires", "America/Tijuana", "America_Pacific", "America/Los_Angeles", "Asia/Harbin", "China", "Asia/Shanghai", 
      "Pacific/Honolulu", "Hawaii_Aleutian", "Pacific/Honolulu", "Atlantic/Azores", "Azores", "Atlantic/Azores", "Indian/Mayotte", "Africa_Eastern", "Africa/Nairobi", "America/Guatemala", 
      "America_Central", "America/Chicago", "America/Indianapolis", "America_Eastern", "America/New_York", "America/Halifax", "Atlantic", "America/Halifax", "America/Resolute", "America_Central", 
      "America/Chicago", "Europe/London", "GMT", "Atlantic/Reykjavik", "America/Hermosillo", "America_Mountain", "America/Denver", "Atlantic/Madeira", "Europe_Western", "Atlantic/Canary", 
      "Europe/Zagreb", "Europe_Central", "Europe/Paris", "America/Boa_Vista", "Amazon", "America/Manaus", "America/Regina", "America_Central", "America/Chicago", "America/Cordoba", 
      "Argentina", "America/Buenos_Aires", "America/Shiprock", "America_Mountain", "America/Denver", "Europe/Luxembourg", "Europe_Central", "Europe/Paris", "America/Cancun", "America_Central", 
      "America/Chicago", "Pacific/Enderbury", "Phoenix_Islands", "Pacific/Enderbury", "Africa/Bissau", "GMT", "Atlantic/Reykjavik", "Antarctica/Vostok", "Vostok", "Antarctica/Vostok", 
      "Pacific/Apia", "Samoa", "Pacific/Apia", "Australia/Perth", "Australia_Western", "Australia/Perth", "America/Juneau", "Alaska", "America/Juneau", "Africa/Mbabane", 
      "Africa_Southern", "Africa/Johannesburg", "Pacific/Niue", "Niue", "Pacific/Niue", "Europe/Zurich", "Europe_Central", "Europe/Paris", "America/Rio_Branco", "Amazon", 
      "America/Manaus", "Africa/Ndjamena", "Africa_Western", "Africa/Lagos", "Asia/Macau", "China", "Asia/Shanghai", "America/Lima", "Peru", "America/Lima", 
      "Africa/Windhoek", "Africa_Central", "Africa/Maputo", "America/Sitka", "Alaska", "America/Juneau", "America/Mazatlan", "America_Mountain", "America/Denver", "Asia/Saigon", 
      "Indochina", "Asia/Saigon", "Asia/Kamchatka", "Magadan", "Asia/Magadan", "America/Menominee", "America_Central", "America/Chicago", "America/Belize", "America_Central", 
      "America/Chicago", "America/Sao_Paulo", "Brasilia", "America/Sao_Paulo", "America/Barbados", "Atlantic", "America/Halifax", "America/Porto_Velho", "Amazon", "America/Manaus", 
      "America/Costa_Rica", "America_Central", "America/Chicago", "Europe/Monaco", "Europe_Central", "Europe/Paris", "Europe/Riga", "Europe_Eastern", "Europe/Bucharest", "Europe/Vatican", 
      "Europe_Central", "Europe/Paris", "Europe/Madrid", "Europe_Central", "Europe/Paris", "Africa/Dakar", "GMT", "Atlantic/Reykjavik", "Asia/Damascus", "Europe_Eastern", 
      "Europe/Bucharest", "Asia/Hong_Kong", "Hong_Kong", "Asia/Hong_Kong", "America/Adak", "Hawaii_Aleutian", "Pacific/Honolulu", "Europe/Vilnius", "Europe_Eastern", "Europe/Bucharest", 
      "America/Indiana/Indianapolis", "America_Eastern", "America/New_York", "Africa/Freetown", "GMT", "Atlantic/Reykjavik", "Atlantic/Reykjavik", "GMT", "Atlantic/Reykjavik", "Asia/Ho_Chi_Minh", 
      "Indochina", "Asia/Saigon", "America/St_Kitts", "Atlantic", "America/Halifax", "America/Martinique", "Atlantic", "America/Halifax", "America/Thule", "Atlantic", 
      "America/Halifax", "America/Asuncion", "Paraguay", "America/Asuncion", "Africa/Luanda", "Africa_Western", "Africa/Lagos", "America/Monterrey", "America_Central", "America/Chicago", 
      "Pacific/Fiji", "Fiji", "Pacific/Fiji", "Africa/Banjul", "GMT", "Atlantic/Reykjavik", "America/Grand_Turk", "America_Eastern", "America/New_York", "Pacific/Pitcairn", 
      "Pitcairn", "Pacific/Pitcairn", "America/Montevideo", "Uruguay", "America/Montevideo", "America/Bahia_Banderas", "America_Central", "America/Chicago", "America/Cayman", "America_Eastern", 
      "America/New_York", "Pacific/Norfolk", "Norfolk", "Pacific/Norfolk", "Africa/Ouagadougou", "GMT", "Atlantic/Reykjavik", "America/Maceio", "Brasilia", "America/Sao_Paulo", 
      "Pacific/Guam", "Chamorro", "Pacific/Saipan", "Africa/Monrovia", "GMT", "Atlantic/Reykjavik", "Africa/Bamako", "GMT", "Atlantic/Reykjavik", "Asia/Colombo", 
      "India", "Asia/Calcutta", "Asia/Urumqi", "China", "Asia/Shanghai", "Asia/Kabul", "Afghanistan", "Asia/Kabul", "America/Yakutat", "Alaska", 
      "America/Juneau", "America/Phoenix", "America_Mountain", "America/Denver", "Asia/Nicosia", "Europe_Eastern", "Europe/Bucharest", "Asia/Phnom_Penh", "Indochina", "Asia/Saigon", 
      "America/Rainy_River", "America_Central", "America/Chicago", "Europe/Uzhgorod", "Europe_Eastern", "Europe/Bucharest", "Pacific/Saipan", "Chamorro", "Pacific/Saipan", "America/St_Vincent", 
      "Atlantic", "America/Halifax", "Europe/Rome", "Europe_Central", "Europe/Paris", "America/Nome", "Alaska", "America/Juneau", "Africa/Mogadishu", "Africa_Eastern", 
      "Africa/Nairobi", "Europe/Zaporozhye", "Europe_Eastern", "Europe/Bucharest", "Pacific/Funafuti", "Tuvalu", "Pacific/Funafuti", "Atlantic/South_Georgia", "South_Georgia", "Atlantic/South_Georgia", 
      "Europe/Skopje", "Europe_Central", "Europe/Paris", "Asia/Yekaterinburg", "Yekaterinburg", "Asia/Yekaterinburg", "Australia/Melbourne", "Australia_Eastern", "Australia/Sydney", "America/Argentina/Cordoba", 
      "Argentina", "America/Buenos_Aires", "Africa/Kigali", "Africa_Central", "Africa/Maputo", "Africa/Blantyre", "Africa_Central", "Africa/Maputo", "Africa/Tripoli", "Europe_Eastern", 
      "Europe/Bucharest", "Africa/Gaborone", "Africa_Central", "Africa/Maputo", "Asia/Kuching", "Malaysia", "Asia/Kuching", "Pacific/Nauru", "Nauru", "Pacific/Nauru", 
      "America/Aruba", "Atlantic", "America/Halifax", "America/Antigua", "Atlantic", "America/Halifax", "Europe/Volgograd", "Volgograd", "Europe/Volgograd", "Africa/Djibouti", 
      "Africa_Eastern", "Africa/Nairobi", "America/Catamarca", "Argentina", "America/Buenos_Aires", "Asia/Manila", "Philippines", "Asia/Manila", "Pacific/Kiritimati", "Line_Islands", 
      "Pacific/Kiritimati", "Asia/Shanghai", "China", "Asia/Shanghai", "Pacific/Truk", "Truk", "Pacific/Truk", "Pacific/Tarawa", "Gilbert_Islands", "Pacific/Tarawa", 
      "Africa/Conakry", "GMT", "Atlantic/Reykjavik", "Asia/Bishkek", "Kyrgystan", "Asia/Bishkek", "Europe/Gibraltar", "Europe_Central", "Europe/Paris", "Asia/Rangoon", 
      "Myanmar", "Asia/Rangoon", "Asia/Baku", "Azerbaijan", "Asia/Baku", "America/Santiago", "Chile", "America/Santiago", "America/El_Salvador", "America_Central", 
      "America/Chicago", "America/Noronha", "Noronha", "America/Noronha", "America/St_Thomas", "Atlantic", "America/Halifax", "Atlantic/St_Helena", "GMT", "Atlantic/Reykjavik", 
      "Asia/Krasnoyarsk", "Krasnoyarsk", "Asia/Krasnoyarsk", "America/Vancouver", "America_Pacific", "America/Los_Angeles", "Europe/Belgrade", "Europe_Central", "Europe/Paris", "America/St_Barthelemy", 
      "Atlantic", "America/Halifax", "Asia/Pontianak", "Indonesia_Western", "Asia/Jakarta", "Africa/Lusaka", "Africa_Central", "Africa/Maputo", "America/Godthab", "Greenland_Western", 
      "America/Godthab", "Asia/Dhaka", "Bangladesh", "Asia/Dhaka", "Asia/Dubai", "Gulf", "Asia/Dubai", "Europe/Moscow", "Moscow", "Europe/Moscow", 
      "America/Louisville", "America_Eastern", "America/New_York", "Australia/Darwin", "Australia_Central", "Australia/Adelaide", "America/Santo_Domingo", "Atlantic", "America/Halifax", "America/Argentina/Ushuaia", 
      "Argentina", "America/Buenos_Aires", "America/Tegucigalpa", "America_Central", "America/Chicago", "Asia/Aden", "Arabian", "Asia/Riyadh", "America/Inuvik", "America_Mountain", 
      "America/Denver", "Asia/Beirut", "Europe_Eastern", "Europe/Bucharest", "Asia/Qatar", "Arabian", "Asia/Riyadh", "Europe/Oslo", "Europe_Central", "Europe/Paris", 
      "Asia/Anadyr", "Magadan", "Asia/Magadan", "Pacific/Palau", "Palau", "Pacific/Palau", "Arctic/Longyearbyen", "Europe_Central", "Europe/Paris", "America/Anguilla", 
      "Atlantic", "America/Halifax", "Asia/Aqtau", "Kazakhstan_Western", "Asia/Aqtobe", "Asia/Yerevan", "Armenia", "Asia/Yerevan", "Africa/Lagos", "Africa_Western", 
      "Africa/Lagos", "America/Denver", "America_Mountain", "America/Denver", "Antarctica/Palmer", "Chile", "America/Santiago", "Europe/Stockholm", "Europe_Central", "Europe/Paris", 
      "America/Bahia", "Brasilia", "America/Sao_Paulo", "America/Danmarkshavn", "GMT", "Atlantic/Reykjavik", "Indian/Mauritius", "Mauritius", "Indian/Mauritius", "Pacific/Chatham", 
      "Chatham", "Pacific/Chatham", "Europe/Prague", "Europe_Central", "Europe/Paris", "America/Blanc-Sablon", "Atlantic", "America/Halifax", "America/Bogota", "Colombia", 
      "America/Bogota", "America/Managua", "America_Central", "America/Chicago", "Pacific/Auckland", "New_Zealand", "Pacific/Auckland", "Atlantic/Faroe", "Europe_Western", "Atlantic/Canary", 
      "America/Cambridge_Bay", "America_Mountain", "America/Denver", "America/Los_Angeles", "America_Pacific", "America/Los_Angeles", "Africa/Khartoum", "Africa_Central", "Africa/Maputo", "Europe/Simferopol", 
      "Europe_Eastern", "Europe/Bucharest", "Australia/Currie", "Australia_Eastern", "Australia/Sydney", "Europe/Guernsey", "GMT", "Atlantic/Reykjavik", "Asia/Thimphu", "Bhutan", 
      "Asia/Thimphu", "America/Eirunepe", "Amazon", "America/Manaus", "Africa/Nairobi", "Africa_Eastern", "Africa/Nairobi", "Asia/Yakutsk", "Yakutsk", "Asia/Yakutsk", 
      "Asia/Yangon", "Myanmar", "Asia/Rangoon", "America/Goose_Bay", "Atlantic", "America/Halifax", "Africa/Maseru", "Africa_Southern", "Africa/Johannesburg", "America/Swift_Current", 
      "America_Central", "America/Chicago", "America/Guyana", "Guyana", "America/Guyana", "Asia/Tokyo", "Japan", "Asia/Tokyo", "Indian/Kerguelen", "French_Southern", 
      "Indian/Kerguelen", "America/Belem", "Brasilia", "America/Sao_Paulo", "Pacific/Wallis", "Wallis", "Pacific/Wallis", "America/Whitehorse", "America_Pacific", "America/Los_Angeles", 
      "America/North_Dakota/Beulah", "America_Central", "America/Chicago", "Asia/Jerusalem", "Israel", "Asia/Jerusalem", "Antarctica/Syowa", "Syowa", "Antarctica/Syowa", "America/Thunder_Bay", 
      "America_Eastern", "America/New_York", "Asia/Brunei", "Brunei", "Asia/Brunei", "America/Metlakatla", "America_Pacific", "America/Los_Angeles", "Asia/Dushanbe", "Tajikistan", 
      "Asia/Dushanbe", "Pacific/Kosrae", "Kosrae", "Pacific/Kosrae", "America/Coral_Harbour", "America_Eastern", "America/New_York", "America/Tortola", "Atlantic", "America/Halifax", 
      "Asia/Karachi", "Pakistan", "Asia/Karachi", "Indian/Reunion", "Reunion", "Indian/Reunion", "America/Detroit", "America_Eastern", "America/New_York", "Australia/Eucla", 
      "Australia_CentralWestern", "Australia/Eucla", "Asia/Seoul", "Korea", "Asia/Seoul", "Asia/Singapore", "Singapore", "Asia/Singapore", "Africa/Casablanca", "Europe_Western", 
      "Atlantic/Canary", "Asia/Dili", "East_Timor", "Asia/Dili", "America/Indiana/Vincennes", "America_Eastern", "America/New_York", "Europe/Dublin", "GMT", "Atlantic/Reykjavik", 
      "America/St_Johns", "Newfoundland", "America/St_Johns", "Antarctica/Macquarie", "Macquarie", "Antarctica/Macquarie", "America/Port_of_Spain", "Atlantic", "America/Halifax", "Europe/Budapest", 
      "Europe_Central", "Europe/Paris", "America/Fortaleza", "Brasilia", "America/Sao_Paulo", "Australia/Brisbane", "Australia_Eastern", "Australia/Sydney", "Atlantic/Bermuda", "Atlantic", 
      "America/Halifax", "Asia/Amman", "Europe_Eastern", "Europe/Bucharest", "Asia/Tashkent", "Uzbekistan", "Asia/Tashkent", "Antarctica/DumontDUrville", "DumontDUrville", "Antarctica/DumontDUrville", 
      "Antarctica/Casey", "Australia_Western", "Australia/Perth", "Asia/Vientiane", "Indochina", "Asia/Saigon", "Pacific/Johnston", "Hawaii_Aleutian", "Pacific/Honolulu", "America/Jamaica", 
      "America_Eastern", "America/New_York", "Africa/Addis_Ababa", "Africa_Eastern", "Africa/Nairobi", "Pacific/Ponape", "Ponape", "Pacific/Ponape", "Europe/Jersey", "GMT", 
      "Atlantic/Reykjavik", "Africa/Lome", "GMT", "Atlantic/Reykjavik", "America/Manaus", "Amazon", "America/Manaus", "Africa/Niamey", "Africa_Western", "Africa/Lagos", 
      "Asia/Kashgar", "China", "Asia/Shanghai", "Pacific/Tongatapu", "Tonga", "Pacific/Tongatapu", "Europe/Minsk", "Europe_Eastern", "Europe/Bucharest", "America/Edmonton", 
      "America_Mountain", "America/Denver", "Asia/Baghdad", "Arabian", "Asia/Riyadh", "Asia/Kathmandu", "Nepal", "Asia/Katmandu", "America/Ojinaga", "America_Mountain", 
      "America/Denver", "Africa/Abidjan", "GMT", "Atlantic/Reykjavik", "America/Indiana/Winamac", "America_Eastern", "America/New_York", "Asia/Qyzylorda", "Kazakhstan_Eastern", "Asia/Almaty", 
      "Australia/Sydney", "Australia_Eastern", "Australia/Sydney", "Asia/Ashgabat", "Turkmenistan", "Asia/Ashgabat", "Europe/Amsterdam", "Europe_Central", "Europe/Paris", "America/Dawson_Creek", 
      "America_Mountain", "America/Denver", "Africa/Cairo", "Europe_Eastern", "Europe/Bucharest", "Asia/Pyongyang", "Korea", "Asia/Seoul", "Africa/Kampala", "Africa_Eastern", 
      "Africa/Nairobi", "America/Araguaina", "Brasilia", "America/Sao_Paulo", "Asia/Novokuznetsk", "Novosibirsk", "Asia/Novosibirsk", "Pacific/Kwajalein", "Marshall_Islands", "Pacific/Majuro", 
      "Africa/Lubumbashi", "Africa_Central", "Africa/Maputo", "Asia/Sakhalin", "Sakhalin", "Asia/Sakhalin", "America/Indiana/Vevay", "America_Eastern", "America/New_York", "Africa/Maputo", 
      "Africa_Central", "Africa/Maputo", "Atlantic/Faeroe", "Europe_Western", "Atlantic/Canary", "America/North_Dakota/Center", "America_Central", "America/Chicago", "Pacific/Wake", "Wake", 
      "Pacific/Wake", "Pacific/Pago_Pago", "Samoa", "Pacific/Apia", "America/Moncton", "Atlantic", "America/Halifax", "Africa/Sao_Tome", "Africa_Western", "Africa/Lagos", 
      "America/Glace_Bay", "Atlantic", "America/Halifax", "Asia/Jakarta", "Indonesia_Western", "Asia/Jakarta", "Africa/Asmera", "Africa_Eastern", "Africa/Nairobi", "Europe/Lisbon", 
      "Europe_Western", "Atlantic/Canary", "America/Dawson", "America_Pacific", "America/Los_Angeles", "America/Cayenne", "French_Guiana", "America/Cayenne", "Asia/Bahrain", "Arabian", 
      "Asia/Riyadh", "Europe/Malta", "Europe_Central", "Europe/Paris", "America/Indiana/Tell_City", "America_Central", "America/Chicago", "America/Indiana/Petersburg", "America_Eastern", "America/New_York", 
      "Antarctica/Rothera", "Rothera", "Antarctica/Rothera", "Asia/Aqtobe", "Kazakhstan_Western", "Asia/Aqtobe", "Europe/Vaduz", "Europe_Central", "Europe/Paris", "America/Indiana/Marengo", 
      "America_Eastern", "America/New_York", "Europe/Brussels", "Europe_Central", "Europe/Paris", "Europe/Andorra", "Europe_Central", "Europe/Paris", "America/Indiana/Knox", "America_Central", 
      "America/Chicago", "Pacific/Easter", "Easter", "Pacific/Easter", "America/Argentina/Rio_Gallegos", "Argentina", "America/Buenos_Aires", "Asia/Oral", "Kazakhstan_Western", "Asia/Aqtobe", 
      "Europe/Copenhagen", "Europe_Central", "Europe/Paris", "Africa/Johannesburg", "Africa_Southern", "Africa/Johannesburg", "Pacific/Pohnpei", "Ponape", "Pacific/Ponape", "America/Argentina/Tucuman", 
      "Argentina", "America/Buenos_Aires", "America/Toronto", "America_Eastern", "America/New_York", "Asia/Makassar", "Indonesia_Central", "Asia/Makassar", "Europe/Berlin", "Europe_Central", 
      "Europe/Paris", "America/Argentina/Mendoza", "Argentina", "America/Buenos_Aires", "America/Cuiaba", "Amazon", "America/Manaus", "America/Creston", "America_Mountain", "America/Denver", 
      "Asia/Samarkand", "Uzbekistan", "Asia/Tashkent", "Asia/Hovd", "Hovd", "Asia/Hovd", "Europe/Bratislava", "Europe_Central", "Europe/Paris", "Africa/Accra", 
      "GMT", "Atlantic/Reykjavik", "Africa/Douala", "Africa_Western", "Africa/Lagos", "Africa/Nouakchott", "GMT", "Atlantic/Reykjavik", "Europe/Sofia", "Europe_Eastern", 
      "Europe/Bucharest", "Antarctica/Davis", "Davis", "Antarctica/Davis", "Antarctica/McMurdo", "New_Zealand", "Pacific/Auckland", "Europe/San_Marino", "Europe_Central", "Europe/Paris", 
      "Africa/Porto-Novo", "Africa_Western", "Africa/Lagos", "Asia/Jayapura", "Indonesia_Eastern", "Asia/Jayapura", "America/St_Lucia", "Atlantic", "America/Halifax", "America/Nipigon", 
      "America_Eastern", "America/New_York", "America/Argentina/Catamarca", "Argentina", "America/Buenos_Aires", "Europe/Isle_of_Man", "GMT", "Atlantic/Reykjavik", "America/Kentucky/Louisville", "America_Eastern", 
      "America/New_York", "America/Merida", "America_Central", "America/Chicago", "Pacific/Marquesas", "Marquesas", "Pacific/Marquesas", "Asia/Magadan", "Magadan", "Asia/Magadan", 
      "Africa/Libreville", "Africa_Western", "Africa/Lagos", "Pacific/Efate", "Vanuatu", "Pacific/Efate", "Asia/Kuala_Lumpur", "Malaysia", "Asia/Kuching", "America/Iqaluit", 
      "America_Eastern", "America/New_York", "Indian/Comoro", "Africa_Eastern", "Africa/Nairobi", "America/Panama", "America_Eastern", "America/New_York", "Asia/Hebron", "Europe_Eastern", 
      "Europe/Bucharest", "America/Jujuy", "Argentina", "America/Buenos_Aires", "America/Pangnirtung", "America_Eastern", "America/New_York", "Asia/Tbilisi", "Georgia", "Asia/Tbilisi", 
      "Europe/Podgorica", "Europe_Central", "Europe/Paris", "America/Boise", "America_Mountain", "America/Denver", "Asia/Muscat", "Gulf", "Asia/Dubai", "Indian/Mahe", 
      "Seychelles", "Indian/Mahe", "America/Montreal", "America_Eastern", "America/New_York", "Africa/Bangui", "Africa_Western", "Africa/Lagos", "America/Curacao", "Atlantic", 
      "America/Halifax", "Asia/Taipei", "Taipei", "Asia/Taipei", "Europe/Ljubljana", "Europe_Central", "Europe/Paris", "Atlantic/Stanley", "Falkland", "Atlantic/Stanley", 
      "Pacific/Guadalcanal", "Solomon", "Pacific/Guadalcanal", "Asia/Kuwait", "Arabian", "Asia/Riyadh", "Asia/Riyadh", "Arabian", "Asia/Riyadh", "Europe/Tallinn", 
      "Europe_Eastern", "Europe/Bucharest", "America/New_York", "America_Eastern", "America/New_York", "America/Paramaribo", "Suriname", "America/Paramaribo", "America/Argentina/Buenos_Aires", "Argentina", 
      "America/Buenos_Aires", "Asia/Irkutsk", "Irkutsk", "Asia/Irkutsk", "Asia/Katmandu", "Nepal", "Asia/Katmandu", "America/Kralendijk", "Atlantic", "America/Halifax" };
  
  private static final String[] mzoneMap = { 
      "GMT", "ML", "Africa/Bamako", "GMT", "IE", "Europe/Dublin", "GMT", "SN", "Africa/Dakar", "GMT", 
      "GH", "Africa/Accra", "GMT", "CI", "Africa/Abidjan", "GMT", "BF", "Africa/Ouagadougou", "GMT", "MR", 
      "Africa/Nouakchott", "GMT", "GM", "Africa/Banjul", "GMT", "SL", "Africa/Freetown", "GMT", "GN", "Africa/Conakry", 
      "GMT", "SH", "Atlantic/St_Helena", "GMT", "GB", "Europe/London", "GMT", "LR", "Africa/Monrovia", "GMT", 
      "TG", "Africa/Lome", "Africa_Western", "ST", "Africa/Sao_Tome", "Africa_Western", "CF", "Africa/Bangui", "Africa_Western", "NE", 
      "Africa/Niamey", "Africa_Western", "CM", "Africa/Douala", "Africa_Western", "CD", "Africa/Kinshasa", "Africa_Western", "CG", "Africa/Brazzaville", 
      "Africa_Western", "GA", "Africa/Libreville", "Africa_Western", "TD", "Africa/Ndjamena", "Africa_Western", "AO", "Africa/Luanda", "Africa_Western", 
      "GQ", "Africa/Malabo", "Africa_Eastern", "YT", "Indian/Mayotte", "Africa_Eastern", "UG", "Africa/Kampala", "Africa_Eastern", "ET", 
      "Africa/Addis_Ababa", "Africa_Eastern", "MG", "Indian/Antananarivo", "Africa_Eastern", "TZ", "Africa/Dar_es_Salaam", "Africa_Eastern", "SO", "Africa/Mogadishu", 
      "Africa_Eastern", "ER", "Africa/Asmera", "Africa_Eastern", "KM", "Indian/Comoro", "Africa_Eastern", "DJ", "Africa/Djibouti", "Europe_Central", 
      "GI", "Europe/Gibraltar", "Europe_Central", "DK", "Europe/Copenhagen", "Europe_Central", "SE", "Europe/Stockholm", "Europe_Central", "CH", 
      "Europe/Zurich", "Europe_Central", "AL", "Europe/Tirane", "Europe_Central", "RS", "Europe/Belgrade", "Europe_Central", "HU", "Europe/Budapest", 
      "Europe_Central", "MT", "Europe/Malta", "Europe_Central", "PL", "Europe/Warsaw", "Europe_Central", "ME", "Europe/Podgorica", "Europe_Central", 
      "ES", "Europe/Madrid", "Europe_Central", "CZ", "Europe/Prague", "Europe_Central", "IT", "Europe/Rome", "Europe_Central", "SI", 
      "Europe/Ljubljana", "Europe_Central", "LI", "Europe/Vaduz", "Europe_Central", "AT", "Europe/Vienna", "Europe_Central", "VA", "Europe/Vatican", 
      "Europe_Central", "DE", "Europe/Berlin", "Europe_Central", "NO", "Europe/Oslo", "Europe_Central", "SK", "Europe/Bratislava", "Europe_Central", 
      "AD", "Europe/Andorra", "Europe_Central", "SM", "Europe/San_Marino", "Europe_Central", "MK", "Europe/Skopje", "Europe_Central", "TN", 
      "Africa/Tunis", "Europe_Central", "HR", "Europe/Zagreb", "Europe_Central", "NL", "Europe/Amsterdam", "Europe_Central", "BE", "Europe/Brussels", 
      "Europe_Central", "MC", "Europe/Monaco", "Europe_Central", "LU", "Europe/Luxembourg", "Europe_Central", "BA", "Europe/Sarajevo", "China", 
      "MO", "Asia/Macau", "America_Pacific", "MX", "America/Tijuana", "America_Pacific", "CA", "America/Vancouver", "Indochina", "LA", 
      "Asia/Vientiane", "Indochina", "KH", "Asia/Phnom_Penh", "Indochina", "TH", "Asia/Bangkok", "Korea", "KP", "Asia/Pyongyang", 
      "America_Mountain", "MX", "America/Hermosillo", "America_Mountain", "CA", "America/Edmonton", "Africa_Southern", "LS", "Africa/Maseru", "Africa_Southern", 
      "SZ", "Africa/Mbabane", "Chile", "AQ", "Antarctica/Palmer", "New_Zealand", "AQ", "Antarctica/McMurdo", "Gulf", "OM", 
      "Asia/Muscat", "Europe_Western", "FO", "Atlantic/Faeroe", "America_Eastern", "TC", "America/Grand_Turk", "America_Eastern", "CA", "America/Toronto", 
      "America_Eastern", "BS", "America/Nassau", "America_Eastern", "PA", "America/Panama", "America_Eastern", "JM", "America/Jamaica", "America_Eastern", 
      "KY", "America/Cayman", "Africa_Central", "BI", "Africa/Bujumbura", "Africa_Central", "ZM", "Africa/Lusaka", "Africa_Central", "ZW", 
      "Africa/Harare", "Africa_Central", "CD", "Africa/Lubumbashi", "Africa_Central", "BW", "Africa/Gaborone", "Africa_Central", "RW", "Africa/Kigali", 
      "Africa_Central", "MW", "Africa/Blantyre", "America_Central", "MX", "America/Mexico_City", "America_Central", "HN", "America/Tegucigalpa", "America_Central", 
      "CA", "America/Winnipeg", "America_Central", "GT", "America/Guatemala", "America_Central", "SV", "America/El_Salvador", "America_Central", "CR", 
      "America/Costa_Rica", "America_Central", "BZ", "America/Belize", "Atlantic", "MS", "America/Montserrat", "Atlantic", "AG", "America/Antigua", 
      "Atlantic", "TT", "America/Port_of_Spain", "Atlantic", "MQ", "America/Martinique", "Atlantic", "DM", "America/Dominica", "Atlantic", 
      "KN", "America/St_Kitts", "Atlantic", "BM", "Atlantic/Bermuda", "Atlantic", "PR", "America/Puerto_Rico", "Atlantic", "AW", 
      "America/Aruba", "Atlantic", "VG", "America/Tortola", "Atlantic", "GD", "America/Grenada", "Atlantic", "GL", "America/Thule", 
      "Atlantic", "BB", "America/Barbados", "Atlantic", "BQ", "America/Kralendijk", "Atlantic", "SX", "America/Lower_Princes", "Atlantic", 
      "VI", "America/St_Thomas", "Atlantic", "MF", "America/Marigot", "Atlantic", "AI", "America/Anguilla", "Atlantic", "AN", 
      "America/Curacao", "Atlantic", "LC", "America/St_Lucia", "Atlantic", "GP", "America/Guadeloupe", "Atlantic", "VC", "America/St_Vincent", 
      "Arabian", "QA", "Asia/Qatar", "Arabian", "YE", "Asia/Aden", "Arabian", "KW", "Asia/Kuwait", "Arabian", 
      "BH", "Asia/Bahrain", "Arabian", "IQ", "Asia/Baghdad", "India", "LK", "Asia/Colombo", "Europe_Eastern", "SY", 
      "Asia/Damascus", "Europe_Eastern", "BG", "Europe/Sofia", "Europe_Eastern", "GR", "Europe/Athens", "Europe_Eastern", "JO", "Asia/Amman", 
      "Europe_Eastern", "CY", "Asia/Nicosia", "Europe_Eastern", "AX", "Europe/Mariehamn", "Europe_Eastern", "LB", "Asia/Beirut", "Europe_Eastern", 
      "FI", "Europe/Helsinki", "Europe_Eastern", "EG", "Africa/Cairo", "Chamorro", "GU", "Pacific/Guam" };
  
  private static final String[] aliasMap = { 
      "Brazil/Acre", "America/Rio_Branco", "US/Indiana-Starke", "America/Indiana/Knox", "America/Atka", "America/Adak", "America/St_Barthelemy", "America/Guadeloupe", "Australia/North", "Australia/Darwin", 
      "Europe/Zagreb", "Europe/Belgrade", "Etc/Universal", "Etc/UTC", "NZ-CHAT", "Pacific/Chatham", "Asia/Macao", "Asia/Macau", "Pacific/Yap", "Pacific/Chuuk", 
      "Egypt", "Africa/Cairo", "US/Central", "America/Chicago", "Canada/Atlantic", "America/Halifax", "Brazil/East", "America/Sao_Paulo", "America/Cordoba", "America/Argentina/Cordoba", 
      "US/Hawaii", "Pacific/Honolulu", "America/Louisville", "America/Kentucky/Louisville", "America/Shiprock", "America/Denver", "Australia/Canberra", "Australia/Sydney", "Asia/Chungking", "Asia/Chongqing", 
      "Universal", "Etc/UTC", "US/Alaska", "America/Anchorage", "Asia/Ujung_Pandang", "Asia/Makassar", "Japan", "Asia/Tokyo", "Atlantic/Faeroe", "Atlantic/Faroe", 
      "Asia/Istanbul", "Europe/Istanbul", "US/Pacific", "America/Los_Angeles", "Mexico/General", "America/Mexico_City", "Poland", "Europe/Warsaw", "Africa/Asmera", "Africa/Asmara", 
      "Asia/Saigon", "Asia/Ho_Chi_Minh", "US/Michigan", "America/Detroit", "America/Argentina/ComodRivadavia", "America/Argentina/Catamarca", "W-SU", "Europe/Moscow", "Australia/ACT", "Australia/Sydney", 
      "Asia/Calcutta", "Asia/Kolkata", "Arctic/Longyearbyen", "Europe/Oslo", "America/Knox_IN", "America/Indiana/Knox", "ROC", "Asia/Taipei", "Zulu", "Etc/UTC", 
      "Australia/Yancowinna", "Australia/Broken_Hill", "Australia/West", "Australia/Perth", "Singapore", "Asia/Singapore", "Europe/Mariehamn", "Europe/Helsinki", "ROK", "Asia/Seoul", 
      "America/Porto_Acre", "America/Rio_Branco", "Etc/Zulu", "Etc/UTC", "Canada/Yukon", "America/Whitehorse", "Europe/Vatican", "Europe/Rome", "Africa/Timbuktu", "Africa/Bamako", 
      "America/Buenos_Aires", "America/Argentina/Buenos_Aires", "Canada/Pacific", "America/Vancouver", "US/Pacific-New", "America/Los_Angeles", "Mexico/BajaNorte", "America/Tijuana", "Europe/Guernsey", "Europe/London", 
      "Asia/Tel_Aviv", "Asia/Jerusalem", "Chile/Continental", "America/Santiago", "Jamaica", "America/Jamaica", "Mexico/BajaSur", "America/Mazatlan", "Canada/Eastern", "America/Toronto", 
      "Australia/Tasmania", "Australia/Hobart", "NZ", "Pacific/Auckland", "America/Lower_Princes", "America/Curacao", "GMT-", "Etc/GMT", "America/Rosario", "America/Argentina/Cordoba", 
      "Libya", "Africa/Tripoli", "Asia/Ashkhabad", "Asia/Ashgabat", "Australia/NSW", "Australia/Sydney", "America/Marigot", "America/Guadeloupe", "Europe/Bratislava", "Europe/Prague", 
      "Portugal", "Europe/Lisbon", "Etc/GMT-", "Etc/GMT", "Europe/San_Marino", "Europe/Rome", "Europe/Sarajevo", "Europe/Belgrade", "Antarctica/South_Pole", "Antarctica/McMurdo", 
      "Canada/Central", "America/Winnipeg", "Etc/GMT", "Etc/GMT", "Europe/Isle_of_Man", "Europe/London", "America/Fort_Wayne", "America/Indiana/Indianapolis", "Eire", "Europe/Dublin", 
      "America/Coral_Harbour", "America/Atikokan", "Europe/Nicosia", "Asia/Nicosia", "US/Samoa", "Pacific/Pago_Pago", "Hongkong", "Asia/Hong_Kong", "Canada/Saskatchewan", "America/Regina", 
      "Asia/Thimbu", "Asia/Thimphu", "Kwajalein", "Pacific/Kwajalein", "GB", "Europe/London", "Chile/EasterIsland", "Pacific/Easter", "US/East-Indiana", "America/Indiana/Indianapolis", 
      "Australia/LHI", "Australia/Lord_Howe", "Cuba", "America/Havana", "America/Jujuy", "America/Argentina/Jujuy", "US/Mountain", "America/Denver", "Atlantic/Jan_Mayen", "Europe/Oslo", 
      "Europe/Tiraspol", "Europe/Chisinau", "Europe/Podgorica", "Europe/Belgrade", "US/Arizona", "America/Phoenix", "Navajo", "America/Denver", "Etc/Greenwich", "Etc/GMT", 
      "Canada/Mountain", "America/Edmonton", "Iceland", "Atlantic/Reykjavik", "Australia/Victoria", "Australia/Melbourne", "Australia/South", "Australia/Adelaide", "Brazil/West", "America/Manaus", 
      "Pacific/Ponape", "Pacific/Pohnpei", "Europe/Ljubljana", "Europe/Belgrade", "Europe/Jersey", "Europe/London", "Australia/Queensland", "Australia/Brisbane", "UTC", "Etc/UTC", 
      "Canada/Newfoundland", "America/St_Johns", "Europe/Skopje", "Europe/Belgrade", "PRC", "Asia/Shanghai", "UCT", "Etc/UCT", "America/Mendoza", "America/Argentina/Mendoza", 
      "Israel", "Asia/Jerusalem", "US/Eastern", "America/New_York", "Asia/Ulan_Bator", "Asia/Ulaanbaatar", "Turkey", "Europe/Istanbul", "GMT", "Etc/GMT", 
      "US/Aleutian", "America/Adak", "Brazil/DeNoronha", "America/Noronha", "GB-Eire", "Europe/London", "Asia/Dacca", "Asia/Dhaka", "America/Ensenada", "America/Tijuana", 
      "America/Catamarca", "America/Argentina/Catamarca", "Iran", "Asia/Tehran", "Greenwich", "Etc/GMT", "Pacific/Truk", "Pacific/Chuuk", "Pacific/Samoa", "Pacific/Pago_Pago", 
      "America/Virgin", "America/St_Thomas", "Asia/Katmandu", "Asia/Kathmandu", "America/Indianapolis", "America/Indiana/Indianapolis", "Europe/Belfast", "Europe/London", "America/Kralendijk", "America/Curacao", 
      "Asia/Rangoon", "Asia/Yangon" };
  
  private static final Map<String, String> zidToMzone = new HashMap();
  
  private static final Map<String, String> mzoneToZid = new HashMap();
  
  private static final Map<String, Map<String, String>> mzoneToZidL = new HashMap();
  
  private static final Map<String, String> aliases = new HashMap();
  
  public static String toZid(String paramString, Locale paramLocale) {
    String str = (String)zidToMzone.get(paramString);
    if (str == null && aliases.containsKey(paramString)) {
      paramString = (String)aliases.get(paramString);
      str = (String)zidToMzone.get(paramString);
    } 
    if (str != null) {
      Map map = (Map)mzoneToZidL.get(str);
      if (map != null && map.containsKey(paramLocale.getCountry())) {
        paramString = (String)map.get(paramLocale.getCountry());
      } else {
        paramString = (String)mzoneToZid.get(str);
      } 
    } 
    return toZid(paramString);
  }
  
  public static String toZid(String paramString) { return aliases.containsKey(paramString) ? (String)aliases.get(paramString) : paramString; }
  
  static  {
    boolean bool;
    for (bool = false; bool < zidMap.length; bool += true) {
      zidToMzone.put(zidMap[bool], zidMap[bool + true]);
      mzoneToZid.put(zidMap[bool + true], zidMap[bool + 2]);
    } 
    for (bool = false; bool < mzoneMap.length; bool += true) {
      String str = mzoneMap[bool];
      Map map = (Map)mzoneToZidL.get(str);
      if (map == null) {
        map = new HashMap();
        mzoneToZidL.put(str, map);
      } 
      map.put(mzoneMap[bool + true], mzoneMap[bool + 2]);
    } 
    for (bool = false; bool < aliasMap.length; bool += true)
      aliases.put(aliasMap[bool], aliasMap[bool + true]); 
  }
}


/* Location:              D:\software\jd-gui\jd-gui-windows-1.6.3\rt.jar!\java\time\format\ZoneName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */