package com.example.wms_erp.ui;

//                                      LWKKKKKKKWKKEGGDEEGGDfLEEKDLDKEEKDEGGEKKEDKG:
//                                     i##W######EEKKW######LEKLLD#fGKKK#EEEKDGE#WK#K
//                                     E#####WWEDK###########K#KfGDGf#EEKEKDLDDKK###KD:
//                                    jW#####EDW#########W######K#fLLW#LGLDG#DGGDKWW#Kt
//                                 .####K###DG######KEKW###KKKKE##LtDEKffLD##KDEGEKKW#Wj
//                                ,#;DG####DK####DDLGGGGED###GEDD#WtDDDLftD###KLLGGKDDEWG
//                                G.,KK###EK###KtiLKKW##KKDD##GDD##tDKL#;D#K#EGffLKK#####f
//                               ;f; E###KW###DfLK#########KLDKLE##DG#f#tD###Kf;G#########
//                               ;D  K##KE###DLjD######W#W##KfLEtK##E#DDGWE##EtE#KE#######t
//                               ;L :W#WK##KDKLKK#######KW##EDDfDt##K#DEE#K##Df#DK#########
//                                ffDKDK##WfKLKW############KffEftL#K#KKK#E##G#Gf#EK#######;
//                                 D###KKKDKEKW###############fjDGtD##K#W#DK#K#t#DEK#W###W#D
//                               G######WW############KK#####KEffGjGW#KK#EGW##KK#LLW####W###
//                              t#########################KWWGfKEDKfK##K#Gj#W####GfLK####W#K
//                               Lf#K###################WKDDWKWKEGfLGGGGEDDtfD##EEKEDW##WW##
//                              :#########################DtGLfLi;ii;;itGLGtjGW#KLt;fK#####E
//                             ;W############W###########EjGtii,:,: .::,iGGtitGW#WKWDGK#K##t
//                             :E####WW#################KGLi,,:,:   ..:,iiLi:;iGKDiL##KW###
//                              L##W############W######KGfti;,:.     ...:,;,::,ifEKDGW#E###
//                             f####WW#######KWW#WW##EKGjti,::.       ..:,,:::::,LW#EGDf##L
//                             ##EW#KWKW###WK##KEEDLGGj;,::...       . ..::...::,;G#DDEEW#;
//                             ##ijfDEW###EE##f,,,,,;i,:::....         .......::,,tKELWW##i
//                           j#####DGGGD#EK#Wt:::,,,,::::......      .........:::,tGELK###;
//                          D#E#DG######WW#G,.::::,:...........  .     ........:::tDDfE###.
//                        :#Ei##EKt:jDtEWD,.:::::,,;i;,.    ..    .  ..........:::tKKDL#KWf
//                       t#t ###ftWtLLDEf,:,::::::,:;itL;,.  ..     .........:.::,jK#DK#KEt
//                     D#f ,W###E .,:,:ii::::.::::,,,::.;tj;. .. . ............::;L##KK#WW;
//                    Lf :iW##K##. .:.:i;,,::::..::,,::...:tf, ...............::;tE###E##K
//                   ;L jL###K####.   :ii;,:::....:,iii;,:. iLi  .......:....::,ijW###K##G
//                    i#####DW##K##Lij:it;,:,:.....:ijEEWGGt,ift:....:..:....:,;tf####W#W;
//                     .f############W;it;,,,::.....:;ffEK#WEfitt,:::::::.::::,;iD######W.
//                        ,#########Kjiiii;,,:::.....,,:tff;tEfiii::::::::::.::;;W#####WD:
//                      :;;#W#######E;tii;;,,::......:,,,;. .fLi;;,::::::::,;fGEK#KW###GE:
//                     ::.#K########E;tii;;,,,:.... ..:,,;;,iit,i::::,::ijLGGGLLE#KWW#KDj
//                     .t;##########E;ti;;;,,,::...  ..:,;iitt,.,,..::jKE##ELtiiW#DW##LLi
//                     :t###KW######E;t;;,;;,,::..   . .:::,::. ,, .:GEEKKff#KjW#KD#W#tLi
//                     . ##D##W#####tit;;,;;,,::...   ....:....::: .iEi,tt :WWK###f#GKL;.
//                      tKL#WDKKK##E;tt;;,;;,,,:...   .::......::: :j:,:,::tKtL#WEG#GfL::
//                      DGWKL##E##D;;tt;,,;;,,,::.........   ...:. ,t::,iitGj;LfWLWDtG,..
//                     ;GKWDWEjK#W,i;tt;,,,;,,:::.........  ....:  ;i:::,ifj,tL;ffEjEj;
//                    .EEGtfEfKE#t,;;tt,,,,,,,,:::........  ..... .ii,::::,,,i;t;EjtL:
//                    D#jGGfE#W#K,;;,tt,,,,,,,,,:::.............  .i;,:::,,,;:;.tEiEi
//                   jKf;#tK#DK#;,,;;it,,,,,,,,,:::.....:.::::..  :i;:::::,,it,:GfDj.
//                  :LK:GKKKE##L:,,,;it;,,,:,,:,,:::.:::::.::::   ,i;::::,,ii. GGLL;
//                   EE:#EGW###,,,,,,it;,,:,::::::::::::..:,..:  .,i,::,,:;, jGGLLi
//                   GGEKWK###t,,:,,,iti,,::::::::::::.   ,:...  .,i:::::,;iDEjffi:
//                    j######ti,:,,,,;ti,:,::::::::::...  :i;..  .,;:::,,ifEE;;tt::
//                     DjG##t:,,::,,,,it,,,:::::..:. .....  it,. .i;::,,i,;; .:t:::
//                       ##f:,,,::,,,,;j;,,,::::..:it   ...  ,i.:fj,:,,it   .  i: ,
//                      .#L:,,,::::,,,,tt,,,::::.:: iL,     ..ifLft,,;i: .i:   t  i
//                       j:,,,,::::,,,,;f;,,::::::.  iLji,:... ,;;;;i,f:  .    i  t.
//                     ,i,:::,::::::,,,,tj,,::::::.. ,;iLj;;,:,;,;;i,t#,  t    ;  :;
//                   ,ii,::::,::::::,:,,;ft,,::::.....tt iDDjtttLit,t#f. .:    ,. :;
//                :,ii,:::::,,:..::::::,,ifi,,:::.:...:ji::tjLLGji,t##E  :      : .,
//            .:;;;,,:::::.,::.....:::::,,tf;,,::......:jt;,,iLf;;:f##f  :      .  ,
//         .,i;;,::::::::.::::..:::::::::,;tj;,:::......,tLjjft;iG K#W:  :         ;
//      :,;;;:::::....::::..::.::::::.::::,;tt;,::.......:,itti G ;KKG:         . .:
//.:,,;;;;,:::::...........::.:.....::.::::,itf,::::.....:::;iiE .DWLG.          ::,
//,;;;,,,,::::.............:.........::.:::,;tjf;:::...:::,,,fWiGLWttE           ;t .
//:,,,,,,,,,,::.::..:......:..........:..::,,iijLi:::::::,,,t#WEfGt jL           ,i
//::...:::,,;,,::::........:.............::,:,ittLj,::::::,f .  ;f iD:           ::
//..:.....::,,;,,::......................::,,:,itjLGfi,,,tD#LG:jD.Lj,            j: .
//.........:::,,i,,::.....:................:::,;ifLLKWKEDEDfDLGKGDtj      .     :t
//
//
//                                         美女镇楼！！！


//                                                               ijGEGDGj:.
//                                                            .:GDDEDEEDGGLGj.
//                                                            LDEKEEEDGffDGEGDG
//                                                          tjEKKGfjjjjfDDfDGDGG.
//                                                         ,GEKEt;;;,;itLDGKEGDGG
//                                                         GDKDi,,,,,;;ijLDGKEDLDL
//                                                       ,LGKGi,,,,,;;;itfDDDKEDDGj
//                                                       GDED;,,,,,,;;;itfGEGDEEKDD.
//                                                      tGEKi,::,,,,;;;;ijLDDDEKDDEG
//                                                .... .GEEj,::,,,,,,;;;itfGEDEDKDDG,
//                                             ..:,;;,,fDKEtfL;,,,,,,;;;iijGDDDKEEKDf
//                                          ..::,;ittttLEW;,;it;,,;;,;;;;itLDEEDKEEED:...
//                                          ..::,;ittttLEW;,;it;,,;;,;;;;itLDEEDKEEED:............
//                                       .:::,,;;iittttEKjjtti;,,;iji;;;;iijGEEGKEKKGjii;;;;;,,,,,.
//                                      .,,,;;iiittttttEKif;Et;,;ittfLt;;;ijGEKDEKWEDLjjjjjjjjjjjj,.
//                                      ,;iiiiiiitttttGG,,;itt:,;iii;ijj;;itLEKEEEKKKDjjjjjjjjjjjj:.
//......                               .,iiiiiiii:,:ttG.:,,,,,,,;itLii;ij;itLEKEGEKWKGtjjjjjjjjjjj:.
//tti;;,:.                             .,iiiiiii.:;,;tE.:,,::,,;;tftKjiiiiitLEKKKEEEWGtjjjjjjjjjjj:.
//fjjjjjt,.......                     ..;iiiiii..;ttiED::,,::,,;;;tifKEi;;;ifEKKEDKKKGtttjjjjjjjjj:
//jjjjjjjt;;;,,,,,::::::..............:,tttttt ::,EGjE;:,;;:,,,;,,;iiitj;;;ifEKKKKDEWEttjjjjjjjjjj:.
//jjjjjjjjjjjjttttjjtttttttiiii;;;,,,;itttttt.,,,,,KDK,,,;,;;;,;,,,,,,,,;;;iLKKKKKEGEEjtjjjjjjjjjj:.
//jjjjjjjjjjjjttttjttttjtttttttttttttttttttt ,;;,,,;WK;,;,,,tG;i;,,,,,,,;;;tDKKWWKEGEEjttjjjjjjjjj:.
//jjjjttjttttttttttttttttttttttttttttttttttt;;;;,,,,;K,,,::;;iti;,,,,,,;;;ifKKKKWWKDGDttjjjjjjjjjt:.
//jjjjjjtttjtttttttttttttttttttittttttttttttti;;;,,,,;,,ti;i;;;;;,,,,;;;;;iGKKEKEWWKDftjjtjjjjjjjt:.
//jjjjtjjttttttttttttttttttttttiiitttttttttttt;;;;,,,,;,;i;jj;,;;;;;;;;;iijDEKKKKKWKEfjjjjjjjjjjjt:.
//jjjjjjjtjjjtttttttttttttttttttitttttttttttttt;;;,,,,t,,,i;ijji;;;;;;;iitGGEDDEKKWKEGLtttttjjjjji:.
//fjjjjjjjjjjjjttttjjjttttttttttttttttttttttttGK;;,:,,t,:;iijjLD;;;;;;;itfLfEDDKEEDKKDjtttjtttjjji:.
//jfjjjjjjjjjjjjttjjjjtjjtjjtjtttttttttttttttfEKK,:::,t::;iitii;;;;;;;iitfjffDGEKDEKKEfttttttjjtji:
//jjfjffffjjjjjtttjjjjjjjjjjtttttttttjjtttttjEKEKE.::,t::,,;;;;;;;;;;iitjEjjLEDWWEKEKEGfjtjjjtjjti:.
//ffffjjjjjjjjttttjjjjjjjjjjjjtttttttjjjjjjtLGjEEK:::,t,:,,,,,;;;;iiittjGDKfLEWWKEKEDKGjjjjjjjjjji:.
//jffjjtttjjjjtiiitjjttttjjjjttiiittjjtjttjGDELED.::,;jG,;;;,,;;iiitjjfLfGWWKWWWWKKDDELLfjjjjjjjji:.
//ffjjttttttttii;ittttittttttti;;;itttttiitLDKfEL.::,;jEjiii;iitttjjfffffDW#KWWW#EKEDELLfjjjjjjjj;..
//ffjtiiiiittti;;iiiiii;iiitti;;;;;itttiiiifGDjfL:::,ifKK###LLfLLfffffjjfE##KK##WKWEDEfDjjjjjjjjj;:.
//ffjtiiiiittti;;iiiii;;;;iiti;;;;;iiii;;;;LGDfG ::,,ifKW##WLfffffffjjjjLG#WKWWWWEEEKKDEjjjjjjjjji:.
//ffjttiiiitttiiiiiii;;;;;iiii;;;;;iiii;;;itDLff.:,,,iKW###WEfjjjjjjttjtjLW#W#W#WKKEKEDGfjjjjjjjji,...
//ffjttittttttiiiitiii;;;;itiii;;;;iiii;;ijiDLf.:::,;iKEWW##KfjttttttttjjDWKWW#KEEEKWKGLLjjjjjjjji,:..
//ffjtttttttttttttttii;;;iiitiiiiiiiiiii;;;iLfi.::,,;tKWWWWWEfjttttiiitjfEEKKEKEKKWWEKDLLjjjjjjjji,::.
//ffjtttttttjtjtttttiiiiiiittttiiittiiiii;;iLf :::,,;GWK#WWWKGjttttiiitjGEtfittGWWKWWKEGfjjjjjjjji;:::
//fjjtttttttttjjttttiiiiiiiitttttttttiiiji;if;.:::,,;WKKW#WKfDjjtttiiitLEK;,,,,;iK##WWDjjjjjjjjjji;,:,
//jjjtttttttjjjttjttiiiiiiiitttttttttii;;;;if..::,,,;WKWWW#KEDLjjttiitjGE,,:,,,:,;j#WKDfjjjjjjjjjt;,,,
//jjjjtttttjjjjttjjttiiiiiittttttttttiiiiitt,.:::,,,iKKWWW#KKKGfjjtttjfD,:::,,,,,:,WWWEGtjjjjjjjjti;;;
//jjjjjjjtjjjjjttjjttttttttttttttttttiiiiijj..::,,,;jKKKWWWKWWGffjtttfE,:::,,,,,,::;WKDfjjjjjjjjjjtiii
//jjjjjjjjjjjtttttttttttttttttttittttttittii.::::,,;EEKKWKWWKKDLffjjjL;:::,,,,,,,,::KKDGjjjjjjjjjjtiii
//jjjjjjjjjjtjttttttjttttttttttiiittttiiijt :::::,,;DKEKKKWKKKDLfffffi,::,,,,,,,,,::;KEEjjjjjjjjjjtiii
//jjjjjjjjjjjttttttjtttttttttttiiittttittfi.:::::,,iDKEKKWKKWEGfffffE;:::,,,,,,,,,,::DDLjjjjjjjjjttiii
//jffjjjjjjjjjjtttjjtttttttttttitttttttttt ::::::,;iDEEKEKKEDDGfjffij,::,,,,,,,,,,,::iELjjjjjjjjjtiii;
//ffffjjjjjjjjjttjjjjjttttttttttttttttttii.:::::,,;fGDDEEKKKLLfftjji,:::,,,,,,,;;,,,::DGjjjjjjjjjttiii
//fffffffjjfjjtttjjjjjjjttttttttttttttttt .:::::,,;GKDGEEKEKfjfftftK::::,,,,,,;;;;,,,:iDjjjjjjjjjtiiii
//fffffffffjjjjttjjjjjjjtttttttttttttttti.::::::,,;GDEDDEKGGfjjjjfj,:::,,,,,,,;;;;,,,::DLjjjjjjjjti;;;
//ffLLLLfffffjtttjjjjjttttjttttiittttttt ::::::,,,;GGDDGEKGLffjjfEj::::,,,,,,;;;;;;,,,:,Ljjjjjjjjttiii
//ffLLLLLLLfjtiiitjjjjjtttttttiiiittttt;.:::::,,,,iDGEGEWEGLffjjjfi:::,,,,,,,;;;;;;;,,,:Gjjjjjjjjtii;;
//ffLGLLLGLfjti;iitjjjjttttttii;;;itjtt..:::::,,,;iDGGGEWDLfffjjjf::::,,,,,,;;;;;;;;,,,:Ejjjjjjjjti;;;
//ffffffffffji;;;itjjjttttttti;;,;ittti.::::,,,,,;jLGDfDEGDfffjjGf:::,,,,,,,;;;;;;;;;,,,:jjjjjjjjttii;
//ffjjttttjjti;;;ittjttiitttti;,,;itti.::::::,,,;;ELGLWDWDGfffjjj,:::,,,,,,;;;;;;i;;;,,,Ljjjjjjjjttiii
//fjjtiiiiitttiiiitttiiiiittti;;;;itLi.:::::,,,,;;LLLKLGLDGfjjjjf:::,,,,,,,;;;;;iii;;;,,;Gjjjjjjjttiii


//                                              哥哥的注释强大吧？？？



























/**
 * Created by Administrator on 2016/10/25.
 */

public class meinv {
}
