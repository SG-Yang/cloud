namespace java com.ahb.common.exchange
//Exchange types
enum ExchangeType {
    JOIN = 1,
    EXIT = 2,
    HEARTBEAT = 3,
    STATUES_TRUE = 4,
    STATUES_FALSE = 5,
    REQ = 6,
    RESP = 7,
    IGNORE = 8,
    CLEAN_TOKEN = 9
}

//Node info

struct NodeAxis {
    1: i32 xAxis,
    2: i32 yAxis,
    3: i32 zAxis,
    4: string ip,
    5: i32 port
}

//Exchange info

struct ExchangeInfo {
    1: string token,
    2: NodeAxis fromNode,
    3: ExchangeType eType,
    4: NodeAxis initNode,
    5: i32 step
}
struct JoinReq {
    1: ExchangeInfo exInfo
}
struct JoinResp {
    1: ExchangeInfo exInfo,
    2: NodeAxis target,
    3: NodeAxis joiner
}

exception InvalidExchange {
    1: i32 errorCode,
    2: string why
}

//Exchange Service
service ExchangeService {
    ExchangeInfo exchange(1: ExchangeInfo input) throws (1: InvalidExchange why),
    JoinResp requestJoin(1: JoinReq req),
    JoinResp doJoin(1: JoinReq req),
    void cleanToken(1:ExchangeInfo token)
}