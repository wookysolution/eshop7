package eshop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import eshop.config.kafka.KafkaProcessor;
import eshop.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlacedu'"
    )
    public void wheneverOrderPlacedu_StartDelivery(
        @Payload OrderPlacedu orderPlacedu
    ) {
        OrderPlacedu event = orderPlacedu;
        System.out.println(
            "\n\n##### listener StartDelivery : " + orderPlacedu + "\n\n"
        );

        // Comments //
        //1. 주문 정보를 토대로, 배송 시작을 하는 단계
        // 2. 계약한 물류사(한진)와 협의한 전문 배송지시 전문 전송
        // 3. 사용자에게 배송 알림 발송
        // 4. 우리 장부에도 키핑

        // Sample Logic //
        Delivery.startDelivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_CancelDelivery(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener CancelDelivery : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        Delivery.cancelDelivery(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
