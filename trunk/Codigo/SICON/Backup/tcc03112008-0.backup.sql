PGDMP
                     
    l           tcc    8.3.0    8.3.0 �   �           0    0    ENCODING    ENCODING !   SET client_encoding = 'WIN1252';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS )   SET standard_conforming_strings = 'off';
                       false                        2615    2200    public    SCHEMA    CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT 6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            �           0    0    public    ACL �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6            ^           1259    27337 	   auditoria    TABLE /  CREATE TABLE auditoria (
    idauditoria integer NOT NULL,
    dataoperacao timestamp with time zone NOT NULL,
    log character varying(10) NOT NULL,
    operacao character varying(50) NOT NULL,
    dados character varying(10000) NOT NULL,
    tabela character varying(50),
    idreferencia integer
);
    DROP TABLE public.auditoria;
       public         postgres    false    6            _           1259    27343    banco    TABLE _   CREATE TABLE banco (
    nome character varying(100) NOT NULL,
    idbanco integer NOT NULL
);
    DROP TABLE public.banco;
       public         postgres    false    6            `           1259    27346    botao    TABLE �   CREATE TABLE botao (
    idbotao integer NOT NULL,
    titulobotao character varying(50),
    nomebotao character varying(50) NOT NULL,
    descricaobotao character varying(100)
);
    DROP TABLE public.botao;
       public         postgres    false    6            @           1247    27351 
   breakpoint    TYPE P   CREATE TYPE breakpoint AS (
	func oid,
	linenumber integer,
	targetname text
);
    DROP TYPE public.breakpoint;
       public       postgres    false    6    1633            b           1259    27352    cardapio    TABLE �   CREATE TABLE cardapio (
    idcardapio integer NOT NULL,
    datacardapio date NOT NULL,
    qtderefeicoes integer NOT NULL,
    idrefeicao integer NOT NULL
);
    DROP TABLE public.cardapio;
       public         postgres    false    6            c           1259    27355    cardapioficha    TABLE e   CREATE TABLE cardapioficha (
    idcardapio integer NOT NULL,
    idfichatecnica integer NOT NULL
);
 !   DROP TABLE public.cardapioficha;
       public         postgres    false    6            d           1259    27358    cargo    TABLE c   CREATE TABLE cargo (
    idcargo integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.cargo;
       public         postgres    false    6            e           1259    27361    composicaocentesimal    TABLE   CREATE TABLE composicaocentesimal (
    idcomposicaocentesimal integer NOT NULL,
    energia numeric(6,3),
    carboidrato numeric(6,3),
    proteina numeric(6,3),
    lipideo numeric(6,3),
    calcio numeric(6,3),
    ferro numeric(6,3),
    vitaminac numeric(6,3)
);
 (   DROP TABLE public.composicaocentesimal;
       public         postgres    false    6            �           1259    27988    configuracoes    TABLE �   CREATE TABLE configuracoes (
    remetente character varying(100),
    senha character varying(50),
    textomensagem character varying(500),
    titulomensagem character(100),
    idconfiguracoes integer NOT NULL
);
 !   DROP TABLE public.configuracoes;
       public         postgres    false    6            f           1259    27364    dadosbancarios    TABLE �   CREATE TABLE dadosbancarios (
    iddadosbancarios integer NOT NULL,
    idbanco integer NOT NULL,
    agencia character varying(20) NOT NULL,
    contacorrente character varying(20) NOT NULL,
    contacorrentedigito character varying(1) NOT NULL
);
 "   DROP TABLE public.dadosbancarios;
       public         postgres    false    6            g           1259    27367    email    TABLE �   CREATE TABLE email (
    idemail integer NOT NULL,
    email character varying(100) NOT NULL,
    idfornecedor integer NOT NULL
);
    DROP TABLE public.email;
       public         postgres    false    6            h           1259    27370    fichatecnica    TABLE �  CREATE TABLE fichatecnica (
    idfichatecnica integer NOT NULL,
    nomepreparacao character varying(70) NOT NULL,
    modopreparo character varying(500),
    rendimento numeric(3,1) NOT NULL,
    energia numeric(6,3),
    carboidrato numeric(6,3),
    proteina numeric(6,3),
    lipideo numeric(6,3),
    calcio numeric(6,3),
    ferro numeric(6,3),
    vitaminac numeric(6,3),
    pesocru numeric(6,3),
    pesoliquido numeric(6,3),
    precototal numeric(4,2)
);
     DROP TABLE public.fichatecnica;
       public         postgres    false    6            i           1259    27373    fichatecnicaitens    TABLE �   CREATE TABLE fichatecnicaitens (
    idfichatecnica integer NOT NULL,
    idproduto integer NOT NULL,
    pesobruto numeric(6,3),
    pesoliquido numeric(6,3),
    fatorcorrecao integer
);
 %   DROP TABLE public.fichatecnicaitens;
       public         postgres    false    6            j           1259    27376    formapagamento    TABLE �   CREATE TABLE formapagamento (
    idformapagamento integer NOT NULL,
    nome character varying(100) NOT NULL,
    operacaobancaria boolean NOT NULL
);
 "   DROP TABLE public.formapagamento;
       public         postgres    false    6            k           1259    27379    formapagamentofornecedor    TABLE �   CREATE TABLE formapagamentofornecedor (
    idformapagamentofornecedor integer NOT NULL,
    idformapagamento integer NOT NULL,
    idfornecedor integer NOT NULL
);
 ,   DROP TABLE public.formapagamentofornecedor;
       public         postgres    false    6            l           1259    27382 
   fornecedor    TABLE J  CREATE TABLE fornecedor (
    idfornecedor integer NOT NULL,
    codigo character varying(15) NOT NULL,
    razaosocial character varying(100) NOT NULL,
    cnpj character varying(14) NOT NULL,
    inscricaoestadual character varying(50),
    ccm character varying(50),
    cgc character varying(50),
    rua character varying(100) NOT NULL,
    numero character varying(10),
    bairro character varying(100),
    cidade character varying(50),
    cep character varying(50),
    site character varying(100),
    tempoentrega integer NOT NULL,
    iddadosbancarios integer DEFAULT 0
);
    DROP TABLE public.fornecedor;
       public         postgres    false    1999    6            m           1259    27386    fornecedorproduto    TABLE   CREATE TABLE fornecedorproduto (
    idfornecedorproduto integer NOT NULL,
    idproduto integer NOT NULL,
    idfornecedor integer NOT NULL,
    codprodutofornecedor character varying(10),
    tempoentrega integer,
    idtipofornecedor integer NOT NULL
);
 %   DROP TABLE public.fornecedorproduto;
       public         postgres    false    6            Z           1247    27391    frame    TYPE g   CREATE TYPE frame AS (
	level integer,
	targetname text,
	func oid,
	linenumber integer,
	args text
);
    DROP TYPE public.frame;
       public       postgres    false    6    1646            �           1259    27896    historicopedido    TABLE �   CREATE TABLE historicopedido (
    idhistoricopedido integer NOT NULL,
    idpedido integer NOT NULL,
    idsituacaopedido integer NOT NULL,
    datahistoricopedido timestamp without time zone NOT NULL
);
 #   DROP TABLE public.historicopedido;
       public         postgres    false    6            �           1259    27945    itemavaliacao    TABLE �   CREATE TABLE itemavaliacao (
    iditemavaliacao integer NOT NULL,
    iditempedido integer NOT NULL,
    idmotivo integer,
    idsituacaoitempedido integer NOT NULL,
    adequado boolean NOT NULL,
    dataavaliacao timestamp with time zone
);
 !   DROP TABLE public.itemavaliacao;
       public         postgres    false    6            �           1259    27914 
   itempedido    TABLE �   CREATE TABLE itempedido (
    iditempedido integer NOT NULL,
    idpedido integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL
);
    DROP TABLE public.itempedido;
       public         postgres    false    6            o           1259    27392 
   logsistema    TABLE �   CREATE TABLE logsistema (
    horario timestamp with time zone NOT NULL,
    operacao character varying(10) NOT NULL,
    logvinculado integer,
    idlogsistema integer NOT NULL,
    idusuario integer NOT NULL
);
    DROP TABLE public.logsistema;
       public         postgres    false    6            p           1259    27395 	   mensagens    TABLE �   CREATE TABLE mensagens (
    idmensagem integer NOT NULL,
    mensagem character varying(300) NOT NULL,
    tipomensagem integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.mensagens;
       public         postgres    false    2003    6            q           1259    27399    motivo    TABLE ~   CREATE TABLE motivo (
    idmotivo integer NOT NULL,
    nome character varying(100) NOT NULL,
    baixar boolean NOT NULL
);
    DROP TABLE public.motivo;
       public         postgres    false    6            r           1259    27402 	   movimento    TABLE   CREATE TABLE movimento (
    idmovimento integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idoperacao integer NOT NULL,
    motivooperacao character varying(100),
    datamovimento date NOT NULL
);
    DROP TABLE public.movimento;
       public         postgres    false    6            s           1259    27405    operacao    TABLE �   CREATE TABLE operacao (
    idoperacao integer NOT NULL,
    descricao character varying(50) NOT NULL,
    vlfator integer NOT NULL
);
    DROP TABLE public.operacao;
       public         postgres    false    6            t           1259    27408    ordemproducao    TABLE $  CREATE TABLE ordemproducao (
    idordemproducao integer NOT NULL,
    dataordem date NOT NULL,
    idrefeicao integer NOT NULL,
    idorigemordem integer NOT NULL,
    idsituacaoordem integer NOT NULL,
    setor character varying(100) NOT NULL,
    motivo character varying(250) NOT NULL
);
 !   DROP TABLE public.ordemproducao;
       public         postgres    false    6            u           1259    27411    ordemproduto    TABLE �   CREATE TABLE ordemproduto (
    idordemproducao integer NOT NULL,
    idproduto integer NOT NULL,
    quantidade numeric(9,3) NOT NULL,
    idunidademedida integer NOT NULL,
    idordemproduto integer NOT NULL
);
     DROP TABLE public.ordemproduto;
       public         postgres    false    6            v           1259    27414    origemordem    TABLE o   CREATE TABLE origemordem (
    idorigemordem integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.origemordem;
       public         postgres    false    6            �           1259    27888    pedido    TABLE y   CREATE TABLE pedido (
    idpedido integer NOT NULL,
    idfornecedor integer NOT NULL,
    dataentrega date NOT NULL
);
    DROP TABLE public.pedido;
       public         postgres    false    6            w           1259    27417    perfil    TABLE �   CREATE TABLE perfil (
    idperfil integer NOT NULL,
    nome character varying(100) NOT NULL,
    administrador boolean NOT NULL
);
    DROP TABLE public.perfil;
       public         postgres    false    6            x           1259    27420 
   perfiltela    TABLE �   CREATE TABLE perfiltela (
    idperfiltela integer NOT NULL,
    idperfil integer NOT NULL,
    idtela integer NOT NULL,
    idbotao integer
);
    DROP TABLE public.perfiltela;
       public         postgres    false    6            y           1259    27423    produto    TABLE �  CREATE TABLE produto (
    idproduto integer NOT NULL,
    codigo character varying(10) NOT NULL,
    nome character varying(100) NOT NULL,
    valor numeric(12,2),
    estoqueminimo numeric(6,3) NOT NULL,
    qtdeembalagem numeric(6,3),
    temperaturaentrega numeric(6,2) NOT NULL,
    alimentar boolean NOT NULL,
    idcomposicaocentesimal integer,
    unidadeembalagem integer,
    unidadeestoque integer NOT NULL
);
    DROP TABLE public.produto;
       public         postgres    false    6            r           1247    27428 	   proxyinfo    TYPE �   CREATE TYPE proxyinfo AS (
	serverversionstr text,
	serverversionnum integer,
	proxyapiver integer,
	serverprocessid integer
);
    DROP TYPE public.proxyinfo;
       public       postgres    false    6    1658            {           1259    27429    refeicao    TABLE i   CREATE TABLE refeicao (
    idrefeicao integer NOT NULL,
    descricao character varying(50) NOT NULL
);
    DROP TABLE public.refeicao;
       public         postgres    false    6            |           1259    27432    saldoano    TABLE E  CREATE TABLE saldoano (
    idsaldoano integer NOT NULL,
    ano integer NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldoano;
       public         postgres    false    2015    2016    2017    2018    6            }           1259    27439    saldodia    TABLE l  CREATE TABLE saldodia (
    idsaldodia integer NOT NULL,
    datasaldodia date NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idsaldomes integer NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldodia;
       public         postgres    false    2020    2021    2022    2023    6            ~           1259    27446    saldomes    TABLE f  CREATE TABLE saldomes (
    idsaldomes integer NOT NULL,
    mes integer NOT NULL,
    idsaldoano integer NOT NULL,
    saldoentrada numeric(12,3) DEFAULT 0 NOT NULL,
    saldosaida numeric(12,3) DEFAULT 0 NOT NULL,
    saldocomprometido numeric(12,3) DEFAULT 0 NOT NULL,
    saldopendente numeric(12,3) DEFAULT 0 NOT NULL,
    idproduto integer NOT NULL
);
    DROP TABLE public.saldomes;
       public         postgres    false    2025    2026    2027    2028    6            �           1259    36188    situacaoitempedido    TABLE ~   CREATE TABLE situacaoitempedido (
    idsituacaoitempedido integer NOT NULL,
    descricao character varying(100) NOT NULL
);
 &   DROP TABLE public.situacaoitempedido;
       public         postgres    false    6                       1259    27453    situacaoordem    TABLE s   CREATE TABLE situacaoordem (
    idsituacaoordem integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 !   DROP TABLE public.situacaoordem;
       public         postgres    false    6            �           1259    27880    situacaopedido    TABLE u   CREATE TABLE situacaopedido (
    idsituacaopedido integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 "   DROP TABLE public.situacaopedido;
       public         postgres    false    6            ~           1247    27458 
   targetinfo    TYPE �   CREATE TYPE targetinfo AS (
	target oid,
	schema oid,
	nargs integer,
	argtypes oidvector,
	targetname name,
	argmodes "char"[],
	argnames text[],
	targetlang oid,
	fqname text,
	returnsset boolean,
	returntype oid
);
    DROP TYPE public.targetinfo;
       public       postgres    false    6    1664            �           1259    27459    tela    TABLE �   CREATE TABLE tela (
    idtela integer NOT NULL,
    titulotela character varying(50),
    nometela character varying(50) NOT NULL,
    titulomenu character varying(50)
);
    DROP TABLE public.tela;
       public         postgres    false    6            �           1259    27462 	   telabotao    TABLE x   CREATE TABLE telabotao (
    idtelabotao integer NOT NULL,
    idtela integer NOT NULL,
    idbotao integer NOT NULL
);
    DROP TABLE public.telabotao;
       public         postgres    false    6            �           1259    27465    telefone    TABLE �   CREATE TABLE telefone (
    idtelefone integer NOT NULL,
    ddd character varying(3) NOT NULL,
    telefone character varying(14) NOT NULL,
    idfornecedor integer NOT NULL,
    idtipotelefone integer NOT NULL
);
    DROP TABLE public.telefone;
       public         postgres    false    6            �           1259    27468    tipofornecedor    TABLE u   CREATE TABLE tipofornecedor (
    idtipofornecedor integer NOT NULL,
    descricao character varying(50) NOT NULL
);
 "   DROP TABLE public.tipofornecedor;
       public         postgres    false    6            �           1259    27471    tipotelefone    TABLE q   CREATE TABLE tipotelefone (
    idtipotelefone integer NOT NULL,
    descricao character varying(50) NOT NULL
);
     DROP TABLE public.tipotelefone;
       public         postgres    false    6            �           1259    27474    ultimousuario    TABLE q   CREATE TABLE ultimousuario (
    usuario character varying(15) NOT NULL,
    idultimousuario integer NOT NULL
);
 !   DROP TABLE public.ultimousuario;
       public         postgres    false    6            �           1259    27477    unidademedida    TABLE �   CREATE TABLE unidademedida (
    idunidademedida integer NOT NULL,
    nome character varying(100) NOT NULL,
    miligrama boolean,
    grama boolean,
    quilograma boolean
);
 !   DROP TABLE public.unidademedida;
       public         postgres    false    6            �           1259    27480    usuario    TABLE �   CREATE TABLE usuario (
    idusuario integer NOT NULL,
    idcargo integer NOT NULL,
    idperfil integer NOT NULL,
    nomeusuario character varying(100) NOT NULL,
    senha character varying(30) NOT NULL,
    login character varying(30) NOT NULL
);
    DROP TABLE public.usuario;
       public         postgres    false    6            �           1247    27485    var    TYPE �   CREATE TYPE var AS (
	name text,
	varclass character(1),
	linenumber integer,
	isunique boolean,
	isconst boolean,
	isnotnull boolean,
	dtype oid,
	value text
);
    DROP TYPE public.var;
       public       postgres    false    6    1673                        1255    27486    Gravar_Log()    FUNCTION �I  CREATE FUNCTION "Gravar_Log"() RETURNS trigger
    AS $$/*DECLARE
 -- Retorno da fun��o
 liAux integer;
 -- Auditoria de deletes, (0) desativa
 liDelete integer = 1;
 -- Auditoria de inserts, (0) desativa
 liInsert integer = 1;
 -- Auditoria de updates, (0) desativa
 liUpdate integer = 1;
 -- Nome da tabela auditada
 lsTabela text = 'tabela_teste';
 -- Schema onde os dados ser�o auditados
 SchemaOrigem text = 'public';
 
BEGIN
 SELECT
   count (*)
 FROM
   pg_catalog.pg_language
 INTO liaux
 WHERE
   lanname = 'plpgsql';
 
 -- Verificando se a linguagem foi definida
 IF liAux = 0 THEN
   RAISE EXCEPTION 'PLPGSQL n�o foi definido';
 END IF;
 
 SELECT
   count (*)
 FROM
   pg_catalog.pg_tables
 INTO liaux
 WHERE
   tablename = 'auditoria01';

2� parte:

 -- Veriricando se a tabela de auditoria existe
 IF liAux = 0 THEN
   RAISE EXCEPTION
     'A tabela de auditoria n�o foi definida.';
 END IF;
 
 -- Verifica se a tabela a ser auditada existe
 IF SchemaOrigem IS NULL THEN
   SELECT
     count (*)
   FROM
     pg_tables
   INTO liaux
   WHERE
     tablename = lstabela;
 ELSE
   SELECT
     count (*)
   FROM
     pg_tables
   INTO liaux
   WHERE
     schemaorigem = schemaorigem AND
     tablename = lstabela;
 END IF;
 
 IF liAux = 0 THEN
   RAISE EXCEPTION 'A tabela % n�o exite.',
     SchemaOrigem || lsTabela;
 END IF;*/

 /*         IF (TG_OP = 'DELETE') THEN
            INSERT INTO emp_audit SELECT 'D', now(), user, OLD.*;
            RETURN OLD;
        ELSIF (TG_OP = 'UPDATE') THEN
            INSERT INTO emp_audit SELECT 'U', now(), user, NEW.*;
            RETURN NEW;
        ELSIF (TG_OP = 'INSERT') THEN
            INSERT INTO emp_audit SELECT 'I', now(), user, NEW.*;
            RETURN NEW;
        END IF;
        RETURN NULL; -- result is ignored since this is an AFTER trigger
    END;
*/
/*******************************************************************************************************
* TRIGGER QUE TEM A FUN��O DE REGISTRAR NA TABELA AUDITORIA TODA OPERA��O DE INSERT/UPDATE/DELETE EM 
* TODAS AS TABELAS DO BANCO.
*
*******************************************************************************************************/
 DECLARE 
 TextoDados character varying(5000);
 idRef integer;
 logusuario character varying(30);
 
BEGIN
select usuario from ultimousuario into logusuario;
TextoDados := '|';
-------------------------- INFORMA��ES TABELA CARGO -----------------------------------------------------
  IF (TG_TABLE_NAME = 'cargo') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idcargo;
      TextoDados := TextoDados || 'descricao = '|| NEW.descricao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idcargo;
      TextoDados := TextoDados || 'descricao = '|| OLD.descricao || '|';
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 
 ----------------------------------     INFORMA��ES TABELA BANCO ----------------------------------------
   IF (TG_TABLE_NAME = 'banco') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idbanco;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idbanco;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 
 ----------------------------------     INFORMA��ES TABELA BOTAO ----------------------------------------
   IF (TG_TABLE_NAME = 'botao') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idbotao;
      TextoDados := TextoDados || 'titulobotao = '|| NEW.titulobotao || '|';   
      TextoDados := TextoDados || 'nomebotao = '|| NEW.nomebotao || '|';   
      TextoDados := TextoDados || 'descricaobotao = '|| NEW.descricaobotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idbotao;
      TextoDados := TextoDados || 'titulobotao = '|| OLD.titulobotao || '|';   
      TextoDados := TextoDados || 'nomebotao = '|| OLD.nomebotao || '|';   
      TextoDados := TextoDados || 'descricaobotao = '|| OLD.descricaobotao || '|';      
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA FORMA DE PAGAMENTO ----------------------------------------
   IF (TG_TABLE_NAME = 'formapagamento') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idformapagamento;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'operacaobancaria = '|| NEW.operacaobancaria || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idformapagamento;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'operacaobancaria = '|| OLD.operacaobancaria || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA MOTIVO ----------------------------------------
   IF (TG_TABLE_NAME = 'motivo') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idmotivo;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| NEW.baixar || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idmotivo;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| OLD.baixar || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA PERFIL ----------------------------------------
   IF (TG_TABLE_NAME = 'perfil') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idperfil;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| NEW.administrador || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idperfil;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';   
      TextoDados := TextoDados || 'baixar = '|| OLD.administrador || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA PERFIL TELA ----------------------------------------
   IF (TG_TABLE_NAME = 'perfiltela') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idperfiltela;
      TextoDados := TextoDados || 'idperfil = '|| NEW.idperfil || '|';   
      TextoDados := TextoDados || 'idtela = '|| NEW.idtela || '|';      
      TextoDados := TextoDados || 'idbotao = '|| NEW.idbotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idperfiltela;
      TextoDados := TextoDados || 'idperfil = '|| OLD.idperfil || '|';   
      TextoDados := TextoDados || 'idtela = '|| OLD.idtela || '|';      
      TextoDados := TextoDados || 'idbotao = '|| OLD.idbotao || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

 ----------------------------------     INFORMA��ES TABELA TELA ----------------------------------------
   IF (TG_TABLE_NAME = 'tela') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idtela;
      TextoDados := TextoDados || 'titulotela = '|| NEW.titulotela || '|';   
      TextoDados := TextoDados || 'nometela = '|| NEW.nometela || '|';      
      TextoDados := TextoDados || 'titulomenu = '|| NEW.titulomenu || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idtela;
      TextoDados := TextoDados || 'titulotela = '|| OLD.titulotela || '|';   
      TextoDados := TextoDados || 'nometela = '|| OLD.nometela || '|';      
      TextoDados := TextoDados || 'titulomenu = '|| OLD.titulomenu || '|';           
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA TELABOTAO ----------------------------------------
   IF (TG_TABLE_NAME = 'telabotao') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idtelabotao;
      TextoDados := TextoDados || 'idtela = '|| NEW.idtela || '|';   
      TextoDados := TextoDados || 'idbotao = '|| NEW.idbotao || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idtelabotao;
      TextoDados := TextoDados || 'idtela = '|| OLD.idtela || '|';   
      TextoDados := TextoDados || 'idbotao = '|| OLD.idbotao || '|';          
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA UNIDADE DE MEDIDA ----------------------------------------
   IF (TG_TABLE_NAME = 'unidademedida') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idunidademedida;
      TextoDados := TextoDados || 'nome = '|| NEW.nome || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idunidademedida;
      TextoDados := TextoDados || 'nome = '|| OLD.nome || '|';         
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;

----------------------------------     INFORMA��ES TABELA USU�RIO ----------------------------------------
   IF (TG_TABLE_NAME = 'usuario') THEN
    IF (TG_OP = 'INSERT') OR (TG_OP = 'UPDATE') THEN
      idRef := NEW.idusuario;
      TextoDados := TextoDados || 'idcargo = '|| NEW.idcargo || '|';      
      TextoDados := TextoDados || 'idperfil = '|| NEW.idperfil || '|';      
      TextoDados := TextoDados || 'nomeusuario = '|| NEW.nomeusuario || '|';      
      TextoDados := TextoDados || 'login = '|| NEW.login || '|';      
      TextoDados := TextoDados || 'senha = '|| NEW.senha || '|';      
    ELSIF (TG_OP = 'DELETE') THEN
      idRef := OLD.idusuario;
      TextoDados := TextoDados || 'idcargo = '|| OLD.idcargo || '|';      
      TextoDados := TextoDados || 'idperfil = '|| OLD.idperfil || '|';      
      TextoDados := TextoDados || 'nomeusuario = '|| OLD.nomeusuario || '|';      
      TextoDados := TextoDados || 'login = '|| OLD.login || '|';      
      TextoDados := TextoDados || 'senha = '|| OLD.senha || '|';       
    END IF;
  IF (TG_OP = 'DELETE') THEN
    INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN OLD;
 ELSIF (TG_OP = 'UPDATE') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
 ELSIF (TG_OP = 'INSERT') THEN
   INSERT INTO
      auditoria (dataoperacao, log, operacao, dados, tabela, idreferencia)
      values (CURRENT_TIMESTAMP, 	 
	 logusuario, 	 
	 TG_OP,
         TextoDados,
         TG_TABLE_NAME,
         idRef);
   RETURN NEW;
  END IF;
 END IF;
 RETURN NULL;
 END;$$
    LANGUAGE plpgsql;
 %   DROP FUNCTION public."Gravar_Log"();
       public       postgres    false    6    458                        1255    27488 5   gravarsaldo(date, integer, numeric, integer, integer)    FUNCTION �B  CREATE FUNCTION gravarsaldo(datasaldo date, produto integer, valor numeric, tiposaldo integer, operacao integer, OUT gravousaldo boolean) RETURNS boolean
    AS $$/**********************************************************************************************************
* Objetivo : gravar o saldo nas tabelas de controle do saldo.
*  	     TipoSaldo = 0 - saldoentrada
*	     TipoSaldo = 1 - saldosaida
*	     TipoSaldo = 2 - saldocomprometido
*	     TipoSaldo = 3 - saldopendente
*
*	     O parametro tipo de entrada ser� utilizado apenas nos casos que envolvam saldo comprometido e saldo 
*            pendente.	     
*            operacao = 0 - Entrada
*            operacao = 1 - Saida
* OBS : Quando a aplica��o for alterar um movimento � necessario retirar da entrada ou saida, codigos esses
*       implementado apenas na parte referente a altera��o
**********************************************************************************************************/
DECLARE 
AnoD INTEGER;
MesD INTEGER;
DiaD INTEGER;
Contador INTEGER;
IdEncontrado Integer;
SaldoAntigo NUMERIC(12,3);
Saldo NUMERIC(12,3);
BEGIN
  AnoD := date_part('year', datasaldo);
  MesD := date_part('month', datasaldo);
  DiaD := date_part('day', datasaldo);   
  IdEncontrado := 0;
  SaldoAntigo := 0;
  Saldo := 0;
  SELECT Count(*) FROM saldoano sa INTO Contador WHERE sa.idproduto = produto AND sa.ano = AnoD;
  -- se n�o existe o ano para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldoano ( ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   ( AnoD,valor, 0,0,0, produto);
        ELSIF (tiposaldo = 1) THEN 
        -- se for pra gravar um saldo de saida
        
          INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (AnoD,0,valor,0,0, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN       
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,valor,0, produto);
          ELSE          
            -- se for para diminuir
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,valor ,0, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE        
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,0,valor, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldoano (ano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (AnoD, 0,0,0,valor * -1, produto);
          END IF;
        END IF;   
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    --END IF;
    SELECT currval('saldoano_idano_seq') INTO IdEncontrado;     
/**********************************************************************************************************
*					ALTERAR O VALOR DO ANO
**********************************************************************************************************/
  ELSIF (Contador = 1) THEN
      SELECT idsaldoano from saldoano sa into idEncontrado where sa.idproduto = produto AND sa.ano = AnoD;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldoano 
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and ano = AnoD;	
	IF (operacao = 0) THEN	        
           UPDATE saldoano SET saldoentrada = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
        ELSE
            -- se for para diminuir
           UPDATE saldoano SET saldoentrada = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
        END IF;	       
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD; 
            IF (operacao = 0) THEN	        
                UPDATE saldoano SET saldosaida = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldosaida = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;	           
	 -- se for p atualizar um saldo comprometido            
     ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	    SELECT saldocomprometido
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD;
            IF (operacao = 0) THEN	        
                UPDATE saldoano SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;
	-- se for para gravar um saldo pendente                
        ELSE 
	    SELECT saldopendente
            FROM saldoano 
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and ano = AnoD;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldoano SET saldopendente = SaldoAntigo + Valor WHERE idsaldoano = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldoano SET saldopendente = SaldoAntigo - Valor WHERE idsaldoano = IdEncontrado;
            END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    ELSE
    GRAVOUSALDO := FALSE;
  -- elaborar ROTINA PARA SAIR DA FUN��O
      --ELABORAR ROTINA PARA SAIR DA FUN��O;
    END IF;
GRAVOUSALDO := TRUE;    
/********************************************************************************************************
*				CALCULO PARA O MES
*********************************************************************************************************/ 
  SELECT Count(*) 
  FROM saldomes sm 
       INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano 
  INTO Contador 
  WHERE sm.idproduto = produto AND sm.mes = mesD AND sa.ano = AnoD;
  -- se n�o existe o mes para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (mesD, IdEncontrado, valor, 0,0,0, produto);
	-- se for pra gravar um saldo de saida
        ELSIF (tiposaldo = 1) THEN 
          INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                      values   (mesD, IdEncontrado, 0,valor,0,0, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,valor,0, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,valor ,0, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE        
        -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD,idEncontrado, 0,0,0,valor, produto);
	    -- se for para diminuir
          ELSE             
              INSERT INTO saldomes (mes, idsaldoano, saldoentrada, saldosaida, saldocomprometido, saldopendente, idproduto)
                          values   (mesD, idEncontrado, 0,0,0,valor * -1, produto);
          END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    SELECT currval('saldomes_idsaldomes_seq') INTO IdEncontrado;   
/**********************************************************************************************************
*					ALTERAR O VALOR DO Mes
**********************************************************************************************************/  
   ELSIF (Contador = 1) THEN
      SELECT idsaldomes  
      FROM saldomes sm 
           INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano  
      INTO idEncontrado where sm.idproduto = produto AND sm.mes = mesD AND sa.ano = AnoD;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldoentrada = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldomes SET saldoentrada = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;	          
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldosaida = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
               UPDATE saldomes SET saldosaida = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;	                      
	 -- se for p atualizar um saldo comprometido            
         ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	    SELECT saldocomprometido
        FROM saldomes
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and mes = mesD;
            IF (operacao = 0) THEN	        
                UPDATE saldomes SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldomes SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
            END IF;
	-- se for para gravar um saldo pendente                
        ELSE 
	    SELECT saldopendente
            FROM saldomes
            INTO SaldoAntigo 
            WHERE idproduto = produto 
	          and mes = mesD;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldomes SET saldopendente = SaldoAntigo + Valor WHERE idsaldomes = IdEncontrado;
            ELSE
            -- se for para diminuir
              UPDATE saldomes SET saldopendente = SaldoAntigo - Valor WHERE idsaldomes = IdEncontrado;
          END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
    ELSE
  END IF;
/**********************************************************************************************************
*					Calcular o valor do dia
**********************************************************************************************************/
  SELECT Count(*) FROM saldodia sd INTO Contador WHERE sd.idproduto = produto AND sd.datasaldodia = datasaldo;
  -- se n�o existe o dia para o produto j� gravado
  IF Contador = 0 THEN
      -- se for pra gravar um saldo de entrada
      IF (tiposaldo = 0) THEN
          INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, valor, 0,0,0, IdEncontrado, produto);
	-- se for pra gravar um saldo de saida
        ELSIF (tiposaldo = 1) THEN 
          INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,valor,0,0, IdEncontrado, produto);
	-- se for p gravar um saldo comprometido
        ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,valor,0, IdEncontrado, produto);
            ELSE 
            -- se for para diminuir
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,valor * -1,0, IdEncontrado, produto);
          END IF;
	-- se for para gravar um saldo pendente
        ELSE
          -- se for pra somar
          IF (operacao = 0) THEN
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,0,valor, IdEncontrado, produto);
            ELSE
            -- se for para diminuir
              INSERT INTO saldodia (datasaldodia, saldoentrada, saldosaida, saldocomprometido, saldopendente, idsaldomes,idproduto)
                      values   (datasaldo, 0,0,0,valor * -1, IdEncontrado, produto);
            END IF;
        END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
/**********************************************************************************************************
*					Alterar o valor do dia
**********************************************************************************************************/
  ELSIF (Contador = 1) THEN
      SELECT idsaldodia from saldodia sd into idEncontrado where sd.idproduto = produto AND sd.datasaldodia = datasaldo;
    --atualizar saldo entrada
    IF (tiposaldo = 0) THEN
        SELECT saldoentrada 
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldoentrada = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldoentrada = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;  	              
    -- se for pra ATUALIZAR um saldo de saida        
    ELSIF (tiposaldo = 1) THEN
            SELECT saldosaida
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldosaida = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldosaida = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;  	                      
	 -- se for p atualizar um saldo comprometido            
    ELSIF (tiposaldo = 2) THEN
          -- se for pra somar
	SELECT saldocomprometido
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
            IF (operacao = 0) THEN	        
                UPDATE saldodia SET saldocomprometido = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
            ELSE
            -- se for para diminuir
                UPDATE saldodia SET saldocomprometido = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
	-- se for para gravar um saldo pendente 
           END IF;               
    ELSE
	SELECT saldopendente
        FROM saldodia
        INTO SaldoAntigo 
        WHERE idproduto = produto 
	      and datasaldodia = datasaldo;
          -- se for pra somar
          IF (operacao = 0) THEN
              UPDATE saldodia SET saldopendente = SaldoAntigo + Valor WHERE idsaldodia = IdEncontrado;
          ELSE 
            -- se for para diminuir
              UPDATE saldodia SET saldopendente = SaldoAntigo - Valor WHERE idsaldodia = IdEncontrado;
          END IF;
    END IF;
    --EXCEPTION WHEN division_by_zero THEN GRAVOUSALDO := FALSE;
  ELSE
  END IF;
  /*-- elaborar ROTINA PARA SAIR DA FUN��O
  ELSIF (Contador > 1) THEN
      --ELABORAR ROTINA PARA SAIR DA FUN��O;
      END IF;
  END IF;*/
END;$$
    LANGUAGE plpgsql;
 �   DROP FUNCTION public.gravarsaldo(datasaldo date, produto integer, valor numeric, tiposaldo integer, operacao integer, OUT gravousaldo boolean);
       public       postgres    false    458    6                        1255    27490    pldbg_abort_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_abort_target(session integer) RETURNS SETOF boolean
    AS '$libdir/pldbgapi', 'pldbg_abort_target'
    LANGUAGE c STRICT;
 :   DROP FUNCTION public.pldbg_abort_target(session integer);
       public       postgres    false    6                        1255    27491    pldbg_attach_to_port(integer)    FUNCTION �   CREATE FUNCTION pldbg_attach_to_port(portnumber integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_attach_to_port'
    LANGUAGE c STRICT;
 ?   DROP FUNCTION public.pldbg_attach_to_port(portnumber integer);
       public       postgres    false    6                        1255    27492    pldbg_continue(integer)    FUNCTION �   CREATE FUNCTION pldbg_continue(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_continue'
    LANGUAGE c STRICT;
 6   DROP FUNCTION public.pldbg_continue(session integer);
       public       postgres    false    320    6                        1255    27493    pldbg_create_listener()    FUNCTION �   CREATE FUNCTION pldbg_create_listener() RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_create_listener'
    LANGUAGE c STRICT;
 .   DROP FUNCTION public.pldbg_create_listener();
       public       postgres    false    6                        1255    27494 1   pldbg_deposit_value(integer, text, integer, text)    FUNCTION �   CREATE FUNCTION pldbg_deposit_value(session integer, varname text, linenumber integer, value text) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_deposit_value'
    LANGUAGE c STRICT;
 i   DROP FUNCTION public.pldbg_deposit_value(session integer, varname text, linenumber integer, value text);
       public       postgres    false    6                        1255    27495 ,   pldbg_drop_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_drop_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_drop_breakpoint'
    LANGUAGE c STRICT;
 [   DROP FUNCTION public.pldbg_drop_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6                        1255    27496    pldbg_get_breakpoints(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_breakpoints(session integer) RETURNS SETOF breakpoint
    AS '$libdir/pldbgapi', 'pldbg_get_breakpoints'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_get_breakpoints(session integer);
       public       postgres    false    6    320                        1255    27497    pldbg_get_proxy_info()    FUNCTION �   CREATE FUNCTION pldbg_get_proxy_info() RETURNS proxyinfo
    AS '$libdir/pldbgapi', 'pldbg_get_proxy_info'
    LANGUAGE c STRICT;
 -   DROP FUNCTION public.pldbg_get_proxy_info();
       public       postgres    false    6    370                        1255    27498    pldbg_get_source(integer, oid)    FUNCTION �   CREATE FUNCTION pldbg_get_source(session integer, func oid) RETURNS text
    AS '$libdir/pldbgapi', 'pldbg_get_source'
    LANGUAGE c STRICT;
 B   DROP FUNCTION public.pldbg_get_source(session integer, func oid);
       public       postgres    false    6                        1255    27499    pldbg_get_stack(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_stack(session integer) RETURNS SETOF frame
    AS '$libdir/pldbgapi', 'pldbg_get_stack'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_get_stack(session integer);
       public       postgres    false    6    346                         1255    27500 #   pldbg_get_target_info(text, "char")    FUNCTION �   CREATE FUNCTION pldbg_get_target_info(signature text, targettype "char") RETURNS targetinfo
    AS '$libdir/targetinfo', 'pldbg_get_target_info'
    LANGUAGE c STRICT;
 O   DROP FUNCTION public.pldbg_get_target_info(signature text, targettype "char");
       public       postgres    false    6    382            !            1255    27501    pldbg_get_variables(integer)    FUNCTION �   CREATE FUNCTION pldbg_get_variables(session integer) RETURNS SETOF var
    AS '$libdir/pldbgapi', 'pldbg_get_variables'
    LANGUAGE c STRICT;
 ;   DROP FUNCTION public.pldbg_get_variables(session integer);
       public       postgres    false    400    6            "            1255    27502 $   pldbg_select_frame(integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_select_frame(session integer, frame integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_select_frame'
    LANGUAGE c STRICT;
 I   DROP FUNCTION public.pldbg_select_frame(session integer, frame integer);
       public       postgres    false    6    320            #            1255    27503 +   pldbg_set_breakpoint(integer, oid, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_breakpoint(session integer, func oid, linenumber integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_breakpoint'
    LANGUAGE c STRICT;
 Z   DROP FUNCTION public.pldbg_set_breakpoint(session integer, func oid, linenumber integer);
       public       postgres    false    6            $            1255    27504 ;   pldbg_set_global_breakpoint(integer, oid, integer, integer)    FUNCTION �   CREATE FUNCTION pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer) RETURNS boolean
    AS '$libdir/pldbgapi', 'pldbg_set_global_breakpoint'
    LANGUAGE c;
 t   DROP FUNCTION public.pldbg_set_global_breakpoint(session integer, func oid, linenumber integer, targetpid integer);
       public       postgres    false    6            %            1255    27505    pldbg_step_into(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_into(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_into'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_into(session integer);
       public       postgres    false    6    320            &            1255    27506    pldbg_step_over(integer)    FUNCTION �   CREATE FUNCTION pldbg_step_over(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_step_over'
    LANGUAGE c STRICT;
 7   DROP FUNCTION public.pldbg_step_over(session integer);
       public       postgres    false    6    320            '            1255    27507 "   pldbg_wait_for_breakpoint(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_breakpoint(session integer) RETURNS breakpoint
    AS '$libdir/pldbgapi', 'pldbg_wait_for_breakpoint'
    LANGUAGE c STRICT;
 A   DROP FUNCTION public.pldbg_wait_for_breakpoint(session integer);
       public       postgres    false    6    320            (            1255    27508    pldbg_wait_for_target(integer)    FUNCTION �   CREATE FUNCTION pldbg_wait_for_target(session integer) RETURNS integer
    AS '$libdir/pldbgapi', 'pldbg_wait_for_target'
    LANGUAGE c STRICT;
 =   DROP FUNCTION public.pldbg_wait_for_target(session integer);
       public       postgres    false    6            )            1255    27509    plpgsql_oid_debug(oid)    FUNCTION �   CREATE FUNCTION plpgsql_oid_debug(functionoid oid) RETURNS integer
    AS '$libdir/plugins/plugin_debugger', 'plpgsql_oid_debug'
    LANGUAGE c STRICT;
 9   DROP FUNCTION public.plpgsql_oid_debug(functionoid oid);
       public       postgres    false    6            *            1255    27510 %   retornarsaldo(date, integer, integer)    FUNCTION �  CREATE FUNCTION retornarsaldo(datasaldo date, produto integer, tiposaldo integer, OUT saldo numeric) RETURNS numeric
    AS $$/**************************************************************************************************************************
*    Fun��o que tem como objetivo retornar o saldo requesitado na data passada como parametro
*    tiposaldo 0 = saldo entrada;
*              1 = saldo saida;
*              2 = saldo atual;
*              3 = saldo comprometido
*              4 = saldo pendente
*              5 = saldo comprometido real(somado os que est�o registrados para frente da data requerida - os saldos futuros)  
*              6 = saldo real;
**************************************************************************************************************************/

DECLARE	
AnoD INTEGER;
MesD INTEGER;
MesDString Text;
ValorAno NUMERIC(12,3);
ValorMes NUMERIC(12,3);
ValorDia NUMERIC(12,3);
ValorSaida Numeric(12,3);
ValorAtual Numeric(12,3);
ValorEntrada Numeric(12,3);
ValorPendente Numeric(12,3);
DataConcatenada Text;
ValorComprometido Numeric(12,3);
-- Somar� apenas o comprometido para frente da data requerida;
ValorComprometidoReal Numeric(12,3);
BEGIN
    AnoD := date_part('year', datasaldo);
    MesD := date_part('month', datasaldo);
    IF (char_length(CAST(MesD as Text)) = 1) THEN
        MesDString := '0' || CAST(MesD as Text);
    ELSE
        MesDString := CAST(MesD as Text);
    END IF;
    DataConcatenada := CAST(AnoD AS Text) || MesDString || '01'; 
    
    IF (tiposaldo = 0) OR (tiposaldo = 2) OR (tiposaldo = 6)THEN    
        SELECT SUM(sa.saldoentrada)
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldoentrada) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldoentrada) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorEntrada := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorEntrada;
    END IF;                
    IF (tiposaldo = 1) OR (tiposaldo = 2) OR (tiposaldo = 6)THEN
        SELECT SUM(sa.saldosaida)
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldosaida) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldosaida) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorSaida := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorSaida;    
    END IF;
    IF (tiposaldo = 2) OR (tiposaldo = 6) THEN
        ValorAtual := VerificaNull(ValorEntrada, 0.0)  - VerificaNull(ValorSaida, 0.0);
        saldo := ValorAtual;
    END IF;
    IF (tiposaldo = 3) THEN
        SELECT SUM(sa.saldocomprometido) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldocomprometido) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldocomprometido) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorComprometido := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorComprometido;
    END IF;    
    IF (tiposaldo = 4) OR (tiposaldo = 6) THEN
        SELECT SUM(sa.saldopendente) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldopendente) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldopendente) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia between  Cast(DataConcatenada as Date) AND datasaldo 
        AND sd.idproduto = produto;  

        ValorPendente := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        saldo := ValorPendente;        
    
    END IF;
     --Se for para retornar o valor real do saldo* --ESTUDAR COMO CAPTURAR O VALOR REAL;
    IF (tiposaldo = 5) OR (tiposaldo = 6) THEN
        SELECT SUM(sa.saldocomprometido) 
        FROM saldoano sa INTO ValorAno 
        WHERE sa.ano < AnoD AND sa.idproduto = produto; 
        
        SELECT SUM(sm.saldocomprometido) 
        FROM saldomes sm INNER JOIN saldoano sa ON sm.idsaldoano = sa.idsaldoano INTO ValorMes 
        WHERE sa.ano = AnoD AND sm.mes < MesD AND sm.idproduto = produto; 

        SELECT SUM(sd.saldocomprometido) 
        FROM saldodia sd INTO ValorDia 
        WHERE sd.datasaldodia >= datasaldo 
        AND sd.idproduto = produto;  

        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := ValorComprometidoReal;        
    END IF;
    IF (tiposaldo = 6) THEN
        ValorComprometidoReal := VerificaNull(ValorAno, 0.0) + VerificaNull(ValorMes,0.0) + VerificaNull(ValorDia,0.0); 
        --soma-se o pendente iniciando do primeiro dia do mes;
        saldo := (ValorAtual + ValorPendente) - ValorComprometidoReal;        
    END IF;    
END;$$
    LANGUAGE plpgsql;
 k   DROP FUNCTION public.retornarsaldo(datasaldo date, produto integer, tiposaldo integer, OUT saldo numeric);
       public       postgres    false    6    458            +            1255    27511    verificanull(numeric, numeric)    FUNCTION �   CREATE FUNCTION verificanull(valor numeric, retornar numeric) RETURNS numeric
    AS $$BEGIN
    IF (valor ISNULL) THEN
	RETURN retornar;
    ELSE
        RETURN valor;
    END IF;
END;$$
    LANGUAGE plpgsql;
 D   DROP FUNCTION public.verificanull(valor numeric, retornar numeric);
       public       postgres    false    6    458            �           1259    27512    Auditoria_idAuditoria_seq    SEQUENCE l   CREATE SEQUENCE "Auditoria_idAuditoria_seq"
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public."Auditoria_idAuditoria_seq";
       public       postgres    false    6    1630            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE OWNED BY K   ALTER SEQUENCE "Auditoria_idAuditoria_seq" OWNED BY auditoria.idauditoria;
            public       postgres    false    1674            �           0    0    Auditoria_idAuditoria_seq    SEQUENCE SET C   SELECT pg_catalog.setval('"Auditoria_idAuditoria_seq"', 74, true);
            public       postgres    false    1674            �           1259    27514    botao_idbotao_seq    SEQUENCE b   CREATE SEQUENCE botao_idbotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.botao_idbotao_seq;
       public       postgres    false    1632    6            �           0    0    botao_idbotao_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE botao_idbotao_seq OWNED BY botao.idbotao;
            public       postgres    false    1675            �           0    0    botao_idbotao_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('botao_idbotao_seq', 6, true);
            public       postgres    false    1675            �           1259    27516    cardapio_idcardapio_seq    SEQUENCE h   CREATE SEQUENCE cardapio_idcardapio_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.cardapio_idcardapio_seq;
       public       postgres    false    1634    6            �           0    0    cardapio_idcardapio_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE cardapio_idcardapio_seq OWNED BY cardapio.idcardapio;
            public       postgres    false    1676            �           0    0    cardapio_idcardapio_seq    SEQUENCE SET >   SELECT pg_catalog.setval('cardapio_idcardapio_seq', 1, true);
            public       postgres    false    1676            �           1259    27518    cargo_idcargo_seq    SEQUENCE b   CREATE SEQUENCE cargo_idcargo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.cargo_idcargo_seq;
       public       postgres    false    6    1636            �           0    0    cargo_idcargo_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE cargo_idcargo_seq OWNED BY cargo.idcargo;
            public       postgres    false    1677            �           0    0    cargo_idcargo_seq    SEQUENCE SET 9   SELECT pg_catalog.setval('cargo_idcargo_seq', 50, true);
            public       postgres    false    1677            �           1259    27520 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE �   CREATE SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 F   DROP SEQUENCE public.composicaocentesimal_idcomposicaocentesimal_seq;
       public       postgres    false    1637    6            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE OWNED BY u   ALTER SEQUENCE composicaocentesimal_idcomposicaocentesimal_seq OWNED BY composicaocentesimal.idcomposicaocentesimal;
            public       postgres    false    1678            �           0    0 /   composicaocentesimal_idcomposicaocentesimal_seq    SEQUENCE SET W   SELECT pg_catalog.setval('composicaocentesimal_idcomposicaocentesimal_seq', 21, true);
            public       postgres    false    1678            �           1259    27522 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE t   CREATE SEQUENCE dadosbancarios_iddadosbancarios_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.dadosbancarios_iddadosbancarios_seq;
       public       postgres    false    1638    6            �           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE dadosbancarios_iddadosbancarios_seq OWNED BY dadosbancarios.iddadosbancarios;
            public       postgres    false    1679            �           0    0 #   dadosbancarios_iddadosbancarios_seq    SEQUENCE SET K   SELECT pg_catalog.setval('dadosbancarios_iddadosbancarios_seq', 12, true);
            public       postgres    false    1679            �           1259    27524    email_idemail_seq    SEQUENCE b   CREATE SEQUENCE email_idemail_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 (   DROP SEQUENCE public.email_idemail_seq;
       public       postgres    false    1639    6            �           0    0    email_idemail_seq    SEQUENCE OWNED BY 9   ALTER SEQUENCE email_idemail_seq OWNED BY email.idemail;
            public       postgres    false    1680            �           0    0    email_idemail_seq    SEQUENCE SET 8   SELECT pg_catalog.setval('email_idemail_seq', 9, true);
            public       postgres    false    1680            �           1259    27526    fichatecnica_idfichatecnica_seq    SEQUENCE p   CREATE SEQUENCE fichatecnica_idfichatecnica_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.fichatecnica_idfichatecnica_seq;
       public       postgres    false    1640    6            �           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE fichatecnica_idfichatecnica_seq OWNED BY fichatecnica.idfichatecnica;
            public       postgres    false    1681            �           0    0    fichatecnica_idfichatecnica_seq    SEQUENCE SET F   SELECT pg_catalog.setval('fichatecnica_idfichatecnica_seq', 4, true);
            public       postgres    false    1681            �           1259    27528 #   formapagamento_idformapagamento_seq    SEQUENCE t   CREATE SEQUENCE formapagamento_idformapagamento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.formapagamento_idformapagamento_seq;
       public       postgres    false    6    1642            �           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE formapagamento_idformapagamento_seq OWNED BY formapagamento.idformapagamento;
            public       postgres    false    1682            �           0    0 #   formapagamento_idformapagamento_seq    SEQUENCE SET J   SELECT pg_catalog.setval('formapagamento_idformapagamento_seq', 8, true);
            public       postgres    false    1682            �           1259    27530 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE �   CREATE SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 N   DROP SEQUENCE public.formapagamentofornecedor_idformapagamentofornecedor_seq;
       public       postgres    false    1643    6            �           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE OWNED BY �   ALTER SEQUENCE formapagamentofornecedor_idformapagamentofornecedor_seq OWNED BY formapagamentofornecedor.idformapagamentofornecedor;
            public       postgres    false    1683            �           0    0 7   formapagamentofornecedor_idformapagamentofornecedor_seq    SEQUENCE SET ^   SELECT pg_catalog.setval('formapagamentofornecedor_idformapagamentofornecedor_seq', 5, true);
            public       postgres    false    1683            �           1259    27532    fornecedor_idfornecedor_seq    SEQUENCE l   CREATE SEQUENCE fornecedor_idfornecedor_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.fornecedor_idfornecedor_seq;
       public       postgres    false    6    1644            �           0    0    fornecedor_idfornecedor_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE fornecedor_idfornecedor_seq OWNED BY fornecedor.idfornecedor;
            public       postgres    false    1684            �           0    0    fornecedor_idfornecedor_seq    SEQUENCE SET C   SELECT pg_catalog.setval('fornecedor_idfornecedor_seq', 20, true);
            public       postgres    false    1684            �           1259    27534 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE z   CREATE SEQUENCE fornecedorproduto_idfornecedorproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 @   DROP SEQUENCE public.fornecedorproduto_idfornecedorproduto_seq;
       public       postgres    false    1645    6            �           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE OWNED BY i   ALTER SEQUENCE fornecedorproduto_idfornecedorproduto_seq OWNED BY fornecedorproduto.idfornecedorproduto;
            public       postgres    false    1685            �           0    0 )   fornecedorproduto_idfornecedorproduto_seq    SEQUENCE SET Q   SELECT pg_catalog.setval('fornecedorproduto_idfornecedorproduto_seq', 12, true);
            public       postgres    false    1685            �           1259    27894 %   historicopedido_idhistoricopedido_seq    SEQUENCE v   CREATE SEQUENCE historicopedido_idhistoricopedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 <   DROP SEQUENCE public.historicopedido_idhistoricopedido_seq;
       public       postgres    false    1715    6            �           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE OWNED BY a   ALTER SEQUENCE historicopedido_idhistoricopedido_seq OWNED BY historicopedido.idhistoricopedido;
            public       postgres    false    1714            �           0    0 %   historicopedido_idhistoricopedido_seq    SEQUENCE SET M   SELECT pg_catalog.setval('historicopedido_idhistoricopedido_seq', 20, true);
            public       postgres    false    1714            �           1259    27943 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE r   CREATE SEQUENCE itemavaliacao_iditemavaliacao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.itemavaliacao_iditemavaliacao_seq;
       public       postgres    false    1719    6            �           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE itemavaliacao_iditemavaliacao_seq OWNED BY itemavaliacao.iditemavaliacao;
            public       postgres    false    1718            �           0    0 !   itemavaliacao_iditemavaliacao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('itemavaliacao_iditemavaliacao_seq', 31, true);
            public       postgres    false    1718            �           1259    27912    itempedido_iditempedido_seq    SEQUENCE l   CREATE SEQUENCE itempedido_iditempedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.itempedido_iditempedido_seq;
       public       postgres    false    1717    6            �           0    0    itempedido_iditempedido_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE itempedido_iditempedido_seq OWNED BY itempedido.iditempedido;
            public       postgres    false    1716            �           0    0    itempedido_iditempedido_seq    SEQUENCE SET C   SELECT pg_catalog.setval('itempedido_iditempedido_seq', 43, true);
            public       postgres    false    1716            �           1259    27536    logsistema_idlogsistema_seq    SEQUENCE l   CREATE SEQUENCE logsistema_idlogsistema_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.logsistema_idlogsistema_seq;
       public       postgres    false    1647    6            �           0    0    logsistema_idlogsistema_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE logsistema_idlogsistema_seq OWNED BY logsistema.idlogsistema;
            public       postgres    false    1686            �           0    0    logsistema_idlogsistema_seq    SEQUENCE SET E   SELECT pg_catalog.setval('logsistema_idlogsistema_seq', 1636, true);
            public       postgres    false    1686            �           1259    27538    mensagens_idmensagem_seq    SEQUENCE i   CREATE SEQUENCE mensagens_idmensagem_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 /   DROP SEQUENCE public.mensagens_idmensagem_seq;
       public       postgres    false    6    1648            �           0    0    mensagens_idmensagem_seq    SEQUENCE OWNED BY G   ALTER SEQUENCE mensagens_idmensagem_seq OWNED BY mensagens.idmensagem;
            public       postgres    false    1687            �           0    0    mensagens_idmensagem_seq    SEQUENCE SET @   SELECT pg_catalog.setval('mensagens_idmensagem_seq', 11, true);
            public       postgres    false    1687            �           1259    27540    motivo_idmotivo_seq    SEQUENCE d   CREATE SEQUENCE motivo_idmotivo_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.motivo_idmotivo_seq;
       public       postgres    false    6    1649            �           0    0    motivo_idmotivo_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE motivo_idmotivo_seq OWNED BY motivo.idmotivo;
            public       postgres    false    1688            �           0    0    motivo_idmotivo_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('motivo_idmotivo_seq', 11, true);
            public       postgres    false    1688            �           1259    27542    movimento_idmovimento_seq    SEQUENCE j   CREATE SEQUENCE movimento_idmovimento_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.movimento_idmovimento_seq;
       public       postgres    false    6    1650            �           0    0    movimento_idmovimento_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE movimento_idmovimento_seq OWNED BY movimento.idmovimento;
            public       postgres    false    1689            �           0    0    movimento_idmovimento_seq    SEQUENCE SET A   SELECT pg_catalog.setval('movimento_idmovimento_seq', 25, true);
            public       postgres    false    1689            �           1259    27544    operacao_idoperacao_seq    SEQUENCE y   CREATE SEQUENCE operacao_idoperacao_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.operacao_idoperacao_seq;
       public       postgres    false    1651    6            �           0    0    operacao_idoperacao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE operacao_idoperacao_seq OWNED BY operacao.idoperacao;
            public       postgres    false    1690            �           0    0    operacao_idoperacao_seq    SEQUENCE SET ?   SELECT pg_catalog.setval('operacao_idoperacao_seq', 1, false);
            public       postgres    false    1690            �           1259    27546 !   ordemproducao_idordemproducao_seq    SEQUENCE r   CREATE SEQUENCE ordemproducao_idordemproducao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ordemproducao_idordemproducao_seq;
       public       postgres    false    6    1652            �           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ordemproducao_idordemproducao_seq OWNED BY ordemproducao.idordemproducao;
            public       postgres    false    1691            �           0    0 !   ordemproducao_idordemproducao_seq    SEQUENCE SET I   SELECT pg_catalog.setval('ordemproducao_idordemproducao_seq', 39, true);
            public       postgres    false    1691            �           1259    27548    ordemproduto_idordemproduto_seq    SEQUENCE p   CREATE SEQUENCE ordemproduto_idordemproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.ordemproduto_idordemproduto_seq;
       public       postgres    false    1653    6            �           0    0    ordemproduto_idordemproduto_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE ordemproduto_idordemproduto_seq OWNED BY ordemproduto.idordemproduto;
            public       postgres    false    1692            �           0    0    ordemproduto_idordemproduto_seq    SEQUENCE SET G   SELECT pg_catalog.setval('ordemproduto_idordemproduto_seq', 52, true);
            public       postgres    false    1692            �           1259    27550    origemordem_idorigemordem_seq    SEQUENCE    CREATE SEQUENCE origemordem_idorigemordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 4   DROP SEQUENCE public.origemordem_idorigemordem_seq;
       public       postgres    false    6    1654            �           0    0    origemordem_idorigemordem_seq    SEQUENCE OWNED BY Q   ALTER SEQUENCE origemordem_idorigemordem_seq OWNED BY origemordem.idorigemordem;
            public       postgres    false    1693            �           0    0    origemordem_idorigemordem_seq    SEQUENCE SET E   SELECT pg_catalog.setval('origemordem_idorigemordem_seq', 1, false);
            public       postgres    false    1693            �           1259    27886    pedido_idpedido_seq    SEQUENCE d   CREATE SEQUENCE pedido_idpedido_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.pedido_idpedido_seq;
       public       postgres    false    6    1713            �           0    0    pedido_idpedido_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE pedido_idpedido_seq OWNED BY pedido.idpedido;
            public       postgres    false    1712            �           0    0    pedido_idpedido_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('pedido_idpedido_seq', 25, true);
            public       postgres    false    1712            �           1259    27552    perfil_idperfil_seq    SEQUENCE d   CREATE SEQUENCE perfil_idperfil_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 *   DROP SEQUENCE public.perfil_idperfil_seq;
       public       postgres    false    6    1655            �           0    0    perfil_idperfil_seq    SEQUENCE OWNED BY =   ALTER SEQUENCE perfil_idperfil_seq OWNED BY perfil.idperfil;
            public       postgres    false    1694            �           0    0    perfil_idperfil_seq    SEQUENCE SET ;   SELECT pg_catalog.setval('perfil_idperfil_seq', 25, true);
            public       postgres    false    1694            �           1259    27554    perfiltela_idperfiltela_seq    SEQUENCE l   CREATE SEQUENCE perfiltela_idperfiltela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 2   DROP SEQUENCE public.perfiltela_idperfiltela_seq;
       public       postgres    false    6    1656            �           0    0    perfiltela_idperfiltela_seq    SEQUENCE OWNED BY M   ALTER SEQUENCE perfiltela_idperfiltela_seq OWNED BY perfiltela.idperfiltela;
            public       postgres    false    1695            �           0    0    perfiltela_idperfiltela_seq    SEQUENCE SET C   SELECT pg_catalog.setval('perfiltela_idperfiltela_seq', 79, true);
            public       postgres    false    1695            �           1259    27556    produto_idproduto_seq    SEQUENCE f   CREATE SEQUENCE produto_idproduto_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.produto_idproduto_seq;
       public       postgres    false    6    1657            �           0    0    produto_idproduto_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE produto_idproduto_seq OWNED BY produto.idproduto;
            public       postgres    false    1696            �           0    0    produto_idproduto_seq    SEQUENCE SET =   SELECT pg_catalog.setval('produto_idproduto_seq', 18, true);
            public       postgres    false    1696            �           1259    27558    refeicao_idrefeicao_seq    SEQUENCE h   CREATE SEQUENCE refeicao_idrefeicao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.refeicao_idrefeicao_seq;
       public       postgres    false    6    1659            �           0    0    refeicao_idrefeicao_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE refeicao_idrefeicao_seq OWNED BY refeicao.idrefeicao;
            public       postgres    false    1697            �           0    0    refeicao_idrefeicao_seq    SEQUENCE SET >   SELECT pg_catalog.setval('refeicao_idrefeicao_seq', 6, true);
            public       postgres    false    1697            �           1259    27560    saldoano_idano_seq    SEQUENCE c   CREATE SEQUENCE saldoano_idano_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 )   DROP SEQUENCE public.saldoano_idano_seq;
       public       postgres    false    6    1660            �           0    0    saldoano_idano_seq    SEQUENCE OWNED BY @   ALTER SEQUENCE saldoano_idano_seq OWNED BY saldoano.idsaldoano;
            public       postgres    false    1698            �           0    0    saldoano_idano_seq    SEQUENCE SET :   SELECT pg_catalog.setval('saldoano_idano_seq', 81, true);
            public       postgres    false    1698            �           1259    27562    saldodia_idsaldodia_seq    SEQUENCE h   CREATE SEQUENCE saldodia_idsaldodia_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldodia_idsaldodia_seq;
       public       postgres    false    1661    6            �           0    0    saldodia_idsaldodia_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldodia_idsaldodia_seq OWNED BY saldodia.idsaldodia;
            public       postgres    false    1699            �           0    0    saldodia_idsaldodia_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldodia_idsaldodia_seq', 140, true);
            public       postgres    false    1699            �           1259    27564    saldomes_idsaldomes_seq    SEQUENCE h   CREATE SEQUENCE saldomes_idsaldomes_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.saldomes_idsaldomes_seq;
       public       postgres    false    6    1662            �           0    0    saldomes_idsaldomes_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE saldomes_idsaldomes_seq OWNED BY saldomes.idsaldomes;
            public       postgres    false    1700             	           0    0    saldomes_idsaldomes_seq    SEQUENCE SET @   SELECT pg_catalog.setval('saldomes_idsaldomes_seq', 117, true);
            public       postgres    false    1700            �           1259    36186 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE �   CREATE SEQUENCE situacaoitempedido_idsituacaoitempedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 B   DROP SEQUENCE public.situacaoitempedido_idsituacaoitempedido_seq;
       public       postgres    false    6    1722            	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE OWNED BY m   ALTER SEQUENCE situacaoitempedido_idsituacaoitempedido_seq OWNED BY situacaoitempedido.idsituacaoitempedido;
            public       postgres    false    1721            	           0    0 +   situacaoitempedido_idsituacaoitempedido_seq    SEQUENCE SET S   SELECT pg_catalog.setval('situacaoitempedido_idsituacaoitempedido_seq', 1, false);
            public       postgres    false    1721            �           1259    27566 !   situacaoordem_idsituacaoordem_seq    SEQUENCE �   CREATE SEQUENCE situacaoordem_idsituacaoordem_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.situacaoordem_idsituacaoordem_seq;
       public       postgres    false    6    1663            	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE situacaoordem_idsituacaoordem_seq OWNED BY situacaoordem.idsituacaoordem;
            public       postgres    false    1701            	           0    0 !   situacaoordem_idsituacaoordem_seq    SEQUENCE SET I   SELECT pg_catalog.setval('situacaoordem_idsituacaoordem_seq', 1, false);
            public       postgres    false    1701            �           1259    27878 #   situacaopedido_idsituacaopedido_seq    SEQUENCE �   CREATE SEQUENCE situacaopedido_idsituacaopedido_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.situacaopedido_idsituacaopedido_seq;
       public       postgres    false    1711    6            	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE situacaopedido_idsituacaopedido_seq OWNED BY situacaopedido.idsituacaopedido;
            public       postgres    false    1710            	           0    0 #   situacaopedido_idsituacaopedido_seq    SEQUENCE SET K   SELECT pg_catalog.setval('situacaopedido_idsituacaopedido_seq', 1, false);
            public       postgres    false    1710            �           1259    27568    tela_idtela_seq    SEQUENCE `   CREATE SEQUENCE tela_idtela_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 &   DROP SEQUENCE public.tela_idtela_seq;
       public       postgres    false    1665    6            	           0    0    tela_idtela_seq    SEQUENCE OWNED BY 5   ALTER SEQUENCE tela_idtela_seq OWNED BY tela.idtela;
            public       postgres    false    1702            	           0    0    tela_idtela_seq    SEQUENCE SET 6   SELECT pg_catalog.setval('tela_idtela_seq', 9, true);
            public       postgres    false    1702            �           1259    27570    telabotao_idtelabotao_seq    SEQUENCE j   CREATE SEQUENCE telabotao_idtelabotao_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 0   DROP SEQUENCE public.telabotao_idtelabotao_seq;
       public       postgres    false    6    1666            		           0    0    telabotao_idtelabotao_seq    SEQUENCE OWNED BY I   ALTER SEQUENCE telabotao_idtelabotao_seq OWNED BY telabotao.idtelabotao;
            public       postgres    false    1703            
	           0    0    telabotao_idtelabotao_seq    SEQUENCE SET A   SELECT pg_catalog.setval('telabotao_idtelabotao_seq', 21, true);
            public       postgres    false    1703            �           1259    27572    telefone_idtelefone_seq    SEQUENCE h   CREATE SEQUENCE telefone_idtelefone_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 .   DROP SEQUENCE public.telefone_idtelefone_seq;
       public       postgres    false    1667    6            	           0    0    telefone_idtelefone_seq    SEQUENCE OWNED BY E   ALTER SEQUENCE telefone_idtelefone_seq OWNED BY telefone.idtelefone;
            public       postgres    false    1704            	           0    0    telefone_idtelefone_seq    SEQUENCE SET >   SELECT pg_catalog.setval('telefone_idtelefone_seq', 9, true);
            public       postgres    false    1704            �           1259    27574 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE �   CREATE SEQUENCE tipofornecedor_idtipofornecedor_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 :   DROP SEQUENCE public.tipofornecedor_idtipofornecedor_seq;
       public       postgres    false    6    1668            	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE OWNED BY ]   ALTER SEQUENCE tipofornecedor_idtipofornecedor_seq OWNED BY tipofornecedor.idtipofornecedor;
            public       postgres    false    1705            	           0    0 #   tipofornecedor_idtipofornecedor_seq    SEQUENCE SET K   SELECT pg_catalog.setval('tipofornecedor_idtipofornecedor_seq', 1, false);
            public       postgres    false    1705            �           1259    27576    tipotelefone_idtipotelefone_seq    SEQUENCE �   CREATE SEQUENCE tipotelefone_idtipotelefone_seq
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 6   DROP SEQUENCE public.tipotelefone_idtipotelefone_seq;
       public       postgres    false    6    1669            	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE OWNED BY U   ALTER SEQUENCE tipotelefone_idtipotelefone_seq OWNED BY tipotelefone.idtipotelefone;
            public       postgres    false    1706            	           0    0    tipotelefone_idtipotelefone_seq    SEQUENCE SET G   SELECT pg_catalog.setval('tipotelefone_idtipotelefone_seq', 1, false);
            public       postgres    false    1706            �           1259    27578 !   ultimousuario_idultimousuario_seq    SEQUENCE r   CREATE SEQUENCE ultimousuario_idultimousuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.ultimousuario_idultimousuario_seq;
       public       postgres    false    1670    6            	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE ultimousuario_idultimousuario_seq OWNED BY ultimousuario.idultimousuario;
            public       postgres    false    1707            	           0    0 !   ultimousuario_idultimousuario_seq    SEQUENCE SET H   SELECT pg_catalog.setval('ultimousuario_idultimousuario_seq', 2, true);
            public       postgres    false    1707            �           1259    27580 !   unidademedida_idunidademedida_seq    SEQUENCE r   CREATE SEQUENCE unidademedida_idunidademedida_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 8   DROP SEQUENCE public.unidademedida_idunidademedida_seq;
       public       postgres    false    1671    6            	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE OWNED BY Y   ALTER SEQUENCE unidademedida_idunidademedida_seq OWNED BY unidademedida.idunidademedida;
            public       postgres    false    1708            	           0    0 !   unidademedida_idunidademedida_seq    SEQUENCE SET H   SELECT pg_catalog.setval('unidademedida_idunidademedida_seq', 8, true);
            public       postgres    false    1708            �           1259    27582    usuario_idusuario_seq    SEQUENCE f   CREATE SEQUENCE usuario_idusuario_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.usuario_idusuario_seq;
       public       postgres    false    1672    6            	           0    0    usuario_idusuario_seq    SEQUENCE OWNED BY A   ALTER SEQUENCE usuario_idusuario_seq OWNED BY usuario.idusuario;
            public       postgres    false    1709            	           0    0    usuario_idusuario_seq    SEQUENCE SET <   SELECT pg_catalog.setval('usuario_idusuario_seq', 3, true);
            public       postgres    false    1709            �           2604    27584    idauditoria    DEFAULT m   ALTER TABLE auditoria ALTER COLUMN idauditoria SET DEFAULT nextval('"Auditoria_idAuditoria_seq"'::regclass);
 D   ALTER TABLE public.auditoria ALTER COLUMN idauditoria DROP DEFAULT;
       public       postgres    false    1674    1630            �           2604    27585    idbotao    DEFAULT [   ALTER TABLE botao ALTER COLUMN idbotao SET DEFAULT nextval('botao_idbotao_seq'::regclass);
 <   ALTER TABLE public.botao ALTER COLUMN idbotao DROP DEFAULT;
       public       postgres    false    1675    1632            �           2604    27586 
   idcardapio    DEFAULT g   ALTER TABLE cardapio ALTER COLUMN idcardapio SET DEFAULT nextval('cardapio_idcardapio_seq'::regclass);
 B   ALTER TABLE public.cardapio ALTER COLUMN idcardapio DROP DEFAULT;
       public       postgres    false    1676    1634            �           2604    27587    idcargo    DEFAULT [   ALTER TABLE cargo ALTER COLUMN idcargo SET DEFAULT nextval('cargo_idcargo_seq'::regclass);
 <   ALTER TABLE public.cargo ALTER COLUMN idcargo DROP DEFAULT;
       public       postgres    false    1677    1636            �           2604    27588    idcomposicaocentesimal    DEFAULT �   ALTER TABLE composicaocentesimal ALTER COLUMN idcomposicaocentesimal SET DEFAULT nextval('composicaocentesimal_idcomposicaocentesimal_seq'::regclass);
 Z   ALTER TABLE public.composicaocentesimal ALTER COLUMN idcomposicaocentesimal DROP DEFAULT;
       public       postgres    false    1678    1637            �           2604    27589    iddadosbancarios    DEFAULT    ALTER TABLE dadosbancarios ALTER COLUMN iddadosbancarios SET DEFAULT nextval('dadosbancarios_iddadosbancarios_seq'::regclass);
 N   ALTER TABLE public.dadosbancarios ALTER COLUMN iddadosbancarios DROP DEFAULT;
       public       postgres    false    1679    1638            �           2604    27590    idemail    DEFAULT [   ALTER TABLE email ALTER COLUMN idemail SET DEFAULT nextval('email_idemail_seq'::regclass);
 <   ALTER TABLE public.email ALTER COLUMN idemail DROP DEFAULT;
       public       postgres    false    1680    1639            �           2604    27591    idfichatecnica    DEFAULT w   ALTER TABLE fichatecnica ALTER COLUMN idfichatecnica SET DEFAULT nextval('fichatecnica_idfichatecnica_seq'::regclass);
 J   ALTER TABLE public.fichatecnica ALTER COLUMN idfichatecnica DROP DEFAULT;
       public       postgres    false    1681    1640            �           2604    27592    idformapagamento    DEFAULT    ALTER TABLE formapagamento ALTER COLUMN idformapagamento SET DEFAULT nextval('formapagamento_idformapagamento_seq'::regclass);
 N   ALTER TABLE public.formapagamento ALTER COLUMN idformapagamento DROP DEFAULT;
       public       postgres    false    1682    1642            �           2604    27593    idformapagamentofornecedor    DEFAULT �   ALTER TABLE formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor SET DEFAULT nextval('formapagamentofornecedor_idformapagamentofornecedor_seq'::regclass);
 b   ALTER TABLE public.formapagamentofornecedor ALTER COLUMN idformapagamentofornecedor DROP DEFAULT;
       public       postgres    false    1683    1643            �           2604    27594    idfornecedor    DEFAULT o   ALTER TABLE fornecedor ALTER COLUMN idfornecedor SET DEFAULT nextval('fornecedor_idfornecedor_seq'::regclass);
 F   ALTER TABLE public.fornecedor ALTER COLUMN idfornecedor DROP DEFAULT;
       public       postgres    false    1684    1644            �           2604    27595    idfornecedorproduto    DEFAULT �   ALTER TABLE fornecedorproduto ALTER COLUMN idfornecedorproduto SET DEFAULT nextval('fornecedorproduto_idfornecedorproduto_seq'::regclass);
 T   ALTER TABLE public.fornecedorproduto ALTER COLUMN idfornecedorproduto DROP DEFAULT;
       public       postgres    false    1685    1645            �           2604    27899    idhistoricopedido    DEFAULT �   ALTER TABLE historicopedido ALTER COLUMN idhistoricopedido SET DEFAULT nextval('historicopedido_idhistoricopedido_seq'::regclass);
 P   ALTER TABLE public.historicopedido ALTER COLUMN idhistoricopedido DROP DEFAULT;
       public       postgres    false    1715    1714    1715            �           2604    27948    iditemavaliacao    DEFAULT {   ALTER TABLE itemavaliacao ALTER COLUMN iditemavaliacao SET DEFAULT nextval('itemavaliacao_iditemavaliacao_seq'::regclass);
 L   ALTER TABLE public.itemavaliacao ALTER COLUMN iditemavaliacao DROP DEFAULT;
       public       postgres    false    1719    1718    1719            �           2604    27987    iditempedido    DEFAULT o   ALTER TABLE itempedido ALTER COLUMN iditempedido SET DEFAULT nextval('itempedido_iditempedido_seq'::regclass);
 F   ALTER TABLE public.itempedido ALTER COLUMN iditempedido DROP DEFAULT;
       public       postgres    false    1716    1717    1717            �           2604    27596    idlogsistema    DEFAULT o   ALTER TABLE logsistema ALTER COLUMN idlogsistema SET DEFAULT nextval('logsistema_idlogsistema_seq'::regclass);
 F   ALTER TABLE public.logsistema ALTER COLUMN idlogsistema DROP DEFAULT;
       public       postgres    false    1686    1647            �           2604    27597 
   idmensagem    DEFAULT i   ALTER TABLE mensagens ALTER COLUMN idmensagem SET DEFAULT nextval('mensagens_idmensagem_seq'::regclass);
 C   ALTER TABLE public.mensagens ALTER COLUMN idmensagem DROP DEFAULT;
       public       postgres    false    1687    1648            �           2604    27598    idmotivo    DEFAULT _   ALTER TABLE motivo ALTER COLUMN idmotivo SET DEFAULT nextval('motivo_idmotivo_seq'::regclass);
 >   ALTER TABLE public.motivo ALTER COLUMN idmotivo DROP DEFAULT;
       public       postgres    false    1688    1649            �           2604    27599    idmovimento    DEFAULT k   ALTER TABLE movimento ALTER COLUMN idmovimento SET DEFAULT nextval('movimento_idmovimento_seq'::regclass);
 D   ALTER TABLE public.movimento ALTER COLUMN idmovimento DROP DEFAULT;
       public       postgres    false    1689    1650            �           2604    27600 
   idoperacao    DEFAULT g   ALTER TABLE operacao ALTER COLUMN idoperacao SET DEFAULT nextval('operacao_idoperacao_seq'::regclass);
 B   ALTER TABLE public.operacao ALTER COLUMN idoperacao DROP DEFAULT;
       public       postgres    false    1690    1651            �           2604    27601    idordemproducao    DEFAULT {   ALTER TABLE ordemproducao ALTER COLUMN idordemproducao SET DEFAULT nextval('ordemproducao_idordemproducao_seq'::regclass);
 L   ALTER TABLE public.ordemproducao ALTER COLUMN idordemproducao DROP DEFAULT;
       public       postgres    false    1691    1652            �           2604    27602    idordemproduto    DEFAULT w   ALTER TABLE ordemproduto ALTER COLUMN idordemproduto SET DEFAULT nextval('ordemproduto_idordemproduto_seq'::regclass);
 J   ALTER TABLE public.ordemproduto ALTER COLUMN idordemproduto DROP DEFAULT;
       public       postgres    false    1692    1653            �           2604    27603    idorigemordem    DEFAULT s   ALTER TABLE origemordem ALTER COLUMN idorigemordem SET DEFAULT nextval('origemordem_idorigemordem_seq'::regclass);
 H   ALTER TABLE public.origemordem ALTER COLUMN idorigemordem DROP DEFAULT;
       public       postgres    false    1693    1654            �           2604    27891    idpedido    DEFAULT _   ALTER TABLE pedido ALTER COLUMN idpedido SET DEFAULT nextval('pedido_idpedido_seq'::regclass);
 >   ALTER TABLE public.pedido ALTER COLUMN idpedido DROP DEFAULT;
       public       postgres    false    1712    1713    1713            �           2604    27604    idperfil    DEFAULT _   ALTER TABLE perfil ALTER COLUMN idperfil SET DEFAULT nextval('perfil_idperfil_seq'::regclass);
 >   ALTER TABLE public.perfil ALTER COLUMN idperfil DROP DEFAULT;
       public       postgres    false    1694    1655            �           2604    27605    idperfiltela    DEFAULT o   ALTER TABLE perfiltela ALTER COLUMN idperfiltela SET DEFAULT nextval('perfiltela_idperfiltela_seq'::regclass);
 F   ALTER TABLE public.perfiltela ALTER COLUMN idperfiltela DROP DEFAULT;
       public       postgres    false    1695    1656            �           2604    27606 	   idproduto    DEFAULT c   ALTER TABLE produto ALTER COLUMN idproduto SET DEFAULT nextval('produto_idproduto_seq'::regclass);
 @   ALTER TABLE public.produto ALTER COLUMN idproduto DROP DEFAULT;
       public       postgres    false    1696    1657            �           2604    27607 
   idrefeicao    DEFAULT g   ALTER TABLE refeicao ALTER COLUMN idrefeicao SET DEFAULT nextval('refeicao_idrefeicao_seq'::regclass);
 B   ALTER TABLE public.refeicao ALTER COLUMN idrefeicao DROP DEFAULT;
       public       postgres    false    1697    1659            �           2604    27608 
   idsaldoano    DEFAULT b   ALTER TABLE saldoano ALTER COLUMN idsaldoano SET DEFAULT nextval('saldoano_idano_seq'::regclass);
 B   ALTER TABLE public.saldoano ALTER COLUMN idsaldoano DROP DEFAULT;
       public       postgres    false    1698    1660            �           2604    27609 
   idsaldodia    DEFAULT g   ALTER TABLE saldodia ALTER COLUMN idsaldodia SET DEFAULT nextval('saldodia_idsaldodia_seq'::regclass);
 B   ALTER TABLE public.saldodia ALTER COLUMN idsaldodia DROP DEFAULT;
       public       postgres    false    1699    1661            �           2604    27610 
   idsaldomes    DEFAULT g   ALTER TABLE saldomes ALTER COLUMN idsaldomes SET DEFAULT nextval('saldomes_idsaldomes_seq'::regclass);
 B   ALTER TABLE public.saldomes ALTER COLUMN idsaldomes DROP DEFAULT;
       public       postgres    false    1700    1662            �           2604    36191    idsituacaoitempedido    DEFAULT �   ALTER TABLE situacaoitempedido ALTER COLUMN idsituacaoitempedido SET DEFAULT nextval('situacaoitempedido_idsituacaoitempedido_seq'::regclass);
 V   ALTER TABLE public.situacaoitempedido ALTER COLUMN idsituacaoitempedido DROP DEFAULT;
       public       postgres    false    1721    1722    1722            �           2604    27611    idsituacaoordem    DEFAULT {   ALTER TABLE situacaoordem ALTER COLUMN idsituacaoordem SET DEFAULT nextval('situacaoordem_idsituacaoordem_seq'::regclass);
 L   ALTER TABLE public.situacaoordem ALTER COLUMN idsituacaoordem DROP DEFAULT;
       public       postgres    false    1701    1663            �           2604    27883    idsituacaopedido    DEFAULT    ALTER TABLE situacaopedido ALTER COLUMN idsituacaopedido SET DEFAULT nextval('situacaopedido_idsituacaopedido_seq'::regclass);
 N   ALTER TABLE public.situacaopedido ALTER COLUMN idsituacaopedido DROP DEFAULT;
       public       postgres    false    1710    1711    1711            �           2604    27612    idtela    DEFAULT W   ALTER TABLE tela ALTER COLUMN idtela SET DEFAULT nextval('tela_idtela_seq'::regclass);
 :   ALTER TABLE public.tela ALTER COLUMN idtela DROP DEFAULT;
       public       postgres    false    1702    1665            �           2604    27613    idtelabotao    DEFAULT k   ALTER TABLE telabotao ALTER COLUMN idtelabotao SET DEFAULT nextval('telabotao_idtelabotao_seq'::regclass);
 D   ALTER TABLE public.telabotao ALTER COLUMN idtelabotao DROP DEFAULT;
       public       postgres    false    1703    1666            �           2604    27614 
   idtelefone    DEFAULT g   ALTER TABLE telefone ALTER COLUMN idtelefone SET DEFAULT nextval('telefone_idtelefone_seq'::regclass);
 B   ALTER TABLE public.telefone ALTER COLUMN idtelefone DROP DEFAULT;
       public       postgres    false    1704    1667            �           2604    27615    idtipofornecedor    DEFAULT    ALTER TABLE tipofornecedor ALTER COLUMN idtipofornecedor SET DEFAULT nextval('tipofornecedor_idtipofornecedor_seq'::regclass);
 N   ALTER TABLE public.tipofornecedor ALTER COLUMN idtipofornecedor DROP DEFAULT;
       public       postgres    false    1705    1668            �           2604    27616    idtipotelefone    DEFAULT w   ALTER TABLE tipotelefone ALTER COLUMN idtipotelefone SET DEFAULT nextval('tipotelefone_idtipotelefone_seq'::regclass);
 J   ALTER TABLE public.tipotelefone ALTER COLUMN idtipotelefone DROP DEFAULT;
       public       postgres    false    1706    1669            �           2604    27617    idultimousuario    DEFAULT {   ALTER TABLE ultimousuario ALTER COLUMN idultimousuario SET DEFAULT nextval('ultimousuario_idultimousuario_seq'::regclass);
 L   ALTER TABLE public.ultimousuario ALTER COLUMN idultimousuario DROP DEFAULT;
       public       postgres    false    1707    1670            �           2604    27618    idunidademedida    DEFAULT {   ALTER TABLE unidademedida ALTER COLUMN idunidademedida SET DEFAULT nextval('unidademedida_idunidademedida_seq'::regclass);
 L   ALTER TABLE public.unidademedida ALTER COLUMN idunidademedida DROP DEFAULT;
       public       postgres    false    1708    1671            �           2604    27619 	   idusuario    DEFAULT c   ALTER TABLE usuario ALTER COLUMN idusuario SET DEFAULT nextval('usuario_idusuario_seq'::regclass);
 @   ALTER TABLE public.usuario ALTER COLUMN idusuario DROP DEFAULT;
       public       postgres    false    1709    1672            �          0    27337 	   auditoria 
   TABLE DATA                 public       postgres    false    1630            �          0    27343    banco 
   TABLE DATA                 public       postgres    false    1631            �          0    27346    botao 
   TABLE DATA                 public       postgres    false    1632            �          0    27352    cardapio 
   TABLE DATA                 public       postgres    false    1634            �          0    27355    cardapioficha 
   TABLE DATA                 public       postgres    false    1635            �          0    27358    cargo 
   TABLE DATA                 public       postgres    false    1636            �          0    27361    composicaocentesimal 
   TABLE DATA                 public       postgres    false    1637            �          0    27988    configuracoes 
   TABLE DATA                 public       postgres    false    1720            �          0    27364    dadosbancarios 
   TABLE DATA                 public       postgres    false    1638            �          0    27367    email 
   TABLE DATA                 public       postgres    false    1639            �          0    27370    fichatecnica 
   TABLE DATA                 public       postgres    false    1640            �          0    27373    fichatecnicaitens 
   TABLE DATA                 public       postgres    false    1641            �          0    27376    formapagamento 
   TABLE DATA                 public       postgres    false    1642            �          0    27379    formapagamentofornecedor 
   TABLE DATA                 public       postgres    false    1643            �          0    27382 
   fornecedor 
   TABLE DATA                 public       postgres    false    1644            �          0    27386    fornecedorproduto 
   TABLE DATA                 public       postgres    false    1645            �          0    27896    historicopedido 
   TABLE DATA                 public       postgres    false    1715            �          0    27945    itemavaliacao 
   TABLE DATA                 public       postgres    false    1719            �          0    27914 
   itempedido 
   TABLE DATA                 public       postgres    false    1717            �          0    27392 
   logsistema 
   TABLE DATA                 public       postgres    false    1647            �          0    27395 	   mensagens 
   TABLE DATA                 public       postgres    false    1648            �          0    27399    motivo 
   TABLE DATA                 public       postgres    false    1649            �          0    27402 	   movimento 
   TABLE DATA                 public       postgres    false    1650            �          0    27405    operacao 
   TABLE DATA                 public       postgres    false    1651            �          0    27408    ordemproducao 
   TABLE DATA                 public       postgres    false    1652            �          0    27411    ordemproduto 
   TABLE DATA                 public       postgres    false    1653            �          0    27414    origemordem 
   TABLE DATA                 public       postgres    false    1654            �          0    27888    pedido 
   TABLE DATA                 public       postgres    false    1713            �          0    27417    perfil 
   TABLE DATA                 public       postgres    false    1655            �          0    27420 
   perfiltela 
   TABLE DATA                 public       postgres    false    1656            �          0    27423    produto 
   TABLE DATA                 public       postgres    false    1657            �          0    27429    refeicao 
   TABLE DATA                 public       postgres    false    1659            �          0    27432    saldoano 
   TABLE DATA                 public       postgres    false    1660            �          0    27439    saldodia 
   TABLE DATA                 public       postgres    false    1661            �          0    27446    saldomes 
   TABLE DATA                 public       postgres    false    1662            �          0    36188    situacaoitempedido 
   TABLE DATA                 public       postgres    false    1722            �          0    27453    situacaoordem 
   TABLE DATA                 public       postgres    false    1663            �          0    27880    situacaopedido 
   TABLE DATA                 public       postgres    false    1711            �          0    27459    tela 
   TABLE DATA                 public       postgres    false    1665            �          0    27462 	   telabotao 
   TABLE DATA                 public       postgres    false    1666            �          0    27465    telefone 
   TABLE DATA                 public       postgres    false    1667            �          0    27468    tipofornecedor 
   TABLE DATA                 public       postgres    false    1668            �          0    27471    tipotelefone 
   TABLE DATA                 public       postgres    false    1669            �          0    27474    ultimousuario 
   TABLE DATA                 public       postgres    false    1670            �          0    27477    unidademedida 
   TABLE DATA                 public       postgres    false    1671            �          0    27480    usuario 
   TABLE DATA                 public       postgres    false    1672            �           2606    27621    Auditoria_pkey 
   CONSTRAINT Z   ALTER TABLE ONLY auditoria
    ADD CONSTRAINT "Auditoria_pkey" PRIMARY KEY (idauditoria);
 D   ALTER TABLE ONLY public.auditoria DROP CONSTRAINT "Auditoria_pkey";
       public         postgres    false    1630    1630                        2606    27623    banco_idbanco_key 
   CONSTRAINT N   ALTER TABLE ONLY banco
    ADD CONSTRAINT banco_idbanco_key UNIQUE (idbanco);
 A   ALTER TABLE ONLY public.banco DROP CONSTRAINT banco_idbanco_key;
       public         postgres    false    1631    1631                       2606    27625 
   botao_pkey 
   CONSTRAINT L   ALTER TABLE ONLY botao
    ADD CONSTRAINT botao_pkey PRIMARY KEY (idbotao);
 :   ALTER TABLE ONLY public.botao DROP CONSTRAINT botao_pkey;
       public         postgres    false    1632    1632                       2606    27627    cardapio_pkey 
   CONSTRAINT U   ALTER TABLE ONLY cardapio
    ADD CONSTRAINT cardapio_pkey PRIMARY KEY (idcardapio);
 @   ALTER TABLE ONLY public.cardapio DROP CONSTRAINT cardapio_pkey;
       public         postgres    false    1634    1634                       2606    27629    cardapioficha_pkey 
   CONSTRAINT o   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_pkey PRIMARY KEY (idcardapio, idfichatecnica);
 J   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_pkey;
       public         postgres    false    1635    1635    1635                       2606    27631 
   cargo_pkey 
   CONSTRAINT L   ALTER TABLE ONLY cargo
    ADD CONSTRAINT cargo_pkey PRIMARY KEY (idcargo);
 :   ALTER TABLE ONLY public.cargo DROP CONSTRAINT cargo_pkey;
       public         postgres    false    1636    1636            
           2606    27633    composicaocentesimal_pkey 
   CONSTRAINT y   ALTER TABLE ONLY composicaocentesimal
    ADD CONSTRAINT composicaocentesimal_pkey PRIMARY KEY (idcomposicaocentesimal);
 X   ALTER TABLE ONLY public.composicaocentesimal DROP CONSTRAINT composicaocentesimal_pkey;
       public         postgres    false    1637    1637            Z           2606    36181    configuracoes_pkey 
   CONSTRAINT d   ALTER TABLE ONLY configuracoes
    ADD CONSTRAINT configuracoes_pkey PRIMARY KEY (idconfiguracoes);
 J   ALTER TABLE ONLY public.configuracoes DROP CONSTRAINT configuracoes_pkey;
       public         postgres    false    1720    1720                       2606    27635    dadosbancarios_pkey 
   CONSTRAINT g   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_pkey PRIMARY KEY (iddadosbancarios);
 L   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_pkey;
       public         postgres    false    1638    1638                       2606    27637 
   email_pkey 
   CONSTRAINT L   ALTER TABLE ONLY email
    ADD CONSTRAINT email_pkey PRIMARY KEY (idemail);
 :   ALTER TABLE ONLY public.email DROP CONSTRAINT email_pkey;
       public         postgres    false    1639    1639                       2606    27639    fichatecnica_pkey 
   CONSTRAINT a   ALTER TABLE ONLY fichatecnica
    ADD CONSTRAINT fichatecnica_pkey PRIMARY KEY (idfichatecnica);
 H   ALTER TABLE ONLY public.fichatecnica DROP CONSTRAINT fichatecnica_pkey;
       public         postgres    false    1640    1640                       2606    27641    fichatecnicaitens_pkey 
   CONSTRAINT v   ALTER TABLE ONLY fichatecnicaitens
    ADD CONSTRAINT fichatecnicaitens_pkey PRIMARY KEY (idfichatecnica, idproduto);
 R   ALTER TABLE ONLY public.fichatecnicaitens DROP CONSTRAINT fichatecnicaitens_pkey;
       public         postgres    false    1641    1641    1641                       2606    27643    formapagamento_pkey 
   CONSTRAINT g   ALTER TABLE ONLY formapagamento
    ADD CONSTRAINT formapagamento_pkey PRIMARY KEY (idformapagamento);
 L   ALTER TABLE ONLY public.formapagamento DROP CONSTRAINT formapagamento_pkey;
       public         postgres    false    1642    1642                       2606    27645    formapagamentofornecedor_pkey 
   CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_pkey PRIMARY KEY (idformapagamentofornecedor);
 `   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_pkey;
       public         postgres    false    1643    1643                       2606    27647    fornecedor_codigo_key 
   CONSTRAINT V   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_codigo_key UNIQUE (codigo);
 J   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_codigo_key;
       public         postgres    false    1644    1644                       2606    27649    fornecedor_pkey 
   CONSTRAINT [   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_pkey PRIMARY KEY (idfornecedor);
 D   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_pkey;
       public         postgres    false    1644    1644                       2606    27651    fornecedorproduto_pkey 
   CONSTRAINT p   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_pkey PRIMARY KEY (idfornecedorproduto);
 R   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_pkey;
       public         postgres    false    1645    1645            T           2606    27901    historicopedido_pkey 
   CONSTRAINT j   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_pkey PRIMARY KEY (idhistoricopedido);
 N   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_pkey;
       public         postgres    false    1715    1715            X           2606    27950    iditemavaliacao_pkey 
   CONSTRAINT f   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_pkey PRIMARY KEY (iditemavaliacao);
 L   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_pkey;
       public         postgres    false    1719    1719                       2606    27653    logsistema_pkey 
   CONSTRAINT [   ALTER TABLE ONLY logsistema
    ADD CONSTRAINT logsistema_pkey PRIMARY KEY (idlogsistema);
 D   ALTER TABLE ONLY public.logsistema DROP CONSTRAINT logsistema_pkey;
       public         postgres    false    1647    1647                        2606    27655    mensagens_pkey 
   CONSTRAINT W   ALTER TABLE ONLY mensagens
    ADD CONSTRAINT mensagens_pkey PRIMARY KEY (idmensagem);
 B   ALTER TABLE ONLY public.mensagens DROP CONSTRAINT mensagens_pkey;
       public         postgres    false    1648    1648            "           2606    27657    motivo_pkey 
   CONSTRAINT O   ALTER TABLE ONLY motivo
    ADD CONSTRAINT motivo_pkey PRIMARY KEY (idmotivo);
 <   ALTER TABLE ONLY public.motivo DROP CONSTRAINT motivo_pkey;
       public         postgres    false    1649    1649            $           2606    27659    movimento_pkey 
   CONSTRAINT X   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_pkey PRIMARY KEY (idmovimento);
 B   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_pkey;
       public         postgres    false    1650    1650            &           2606    27661    operacao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY operacao
    ADD CONSTRAINT operacao_pkey PRIMARY KEY (idoperacao);
 @   ALTER TABLE ONLY public.operacao DROP CONSTRAINT operacao_pkey;
       public         postgres    false    1651    1651            (           2606    27663    ordemproducao_pkey 
   CONSTRAINT d   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_pkey PRIMARY KEY (idordemproducao);
 J   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_pkey;
       public         postgres    false    1652    1652            *           2606    27665    ordemproduto_pkey 
   CONSTRAINT a   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_pkey PRIMARY KEY (idordemproduto);
 H   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_pkey;
       public         postgres    false    1653    1653            ,           2606    27667    origemordem_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY origemordem
    ADD CONSTRAINT origemordem_pkey PRIMARY KEY (idorigemordem);
 F   ALTER TABLE ONLY public.origemordem DROP CONSTRAINT origemordem_pkey;
       public         postgres    false    1654    1654            R           2606    27893    pedido_pkey 
   CONSTRAINT O   ALTER TABLE ONLY pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (idpedido);
 <   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedido_pkey;
       public         postgres    false    1713    1713            V           2606    27919    pedidoproduto_pkey 
   CONSTRAINT ^   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_pkey PRIMARY KEY (iditempedido);
 G   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_pkey;
       public         postgres    false    1717    1717            .           2606    27669    perfil_pkey 
   CONSTRAINT O   ALTER TABLE ONLY perfil
    ADD CONSTRAINT perfil_pkey PRIMARY KEY (idperfil);
 <   ALTER TABLE ONLY public.perfil DROP CONSTRAINT perfil_pkey;
       public         postgres    false    1655    1655            0           2606    27671    perfiltela_pkey 
   CONSTRAINT [   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_pkey PRIMARY KEY (idperfiltela);
 D   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_pkey;
       public         postgres    false    1656    1656            2           2606    27673    produto_codigo_key 
   CONSTRAINT P   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_codigo_key UNIQUE (codigo);
 D   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_codigo_key;
       public         postgres    false    1657    1657            4           2606    27675    produto_pkey 
   CONSTRAINT R   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (idproduto);
 >   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_pkey;
       public         postgres    false    1657    1657            6           2606    27677    refeicao_pkey 
   CONSTRAINT U   ALTER TABLE ONLY refeicao
    ADD CONSTRAINT refeicao_pkey PRIMARY KEY (idrefeicao);
 @   ALTER TABLE ONLY public.refeicao DROP CONSTRAINT refeicao_pkey;
       public         postgres    false    1659    1659            8           2606    27679    saldoano_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_pkey PRIMARY KEY (idsaldoano);
 @   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_pkey;
       public         postgres    false    1660    1660            :           2606    27681    saldodia_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_pkey PRIMARY KEY (idsaldodia);
 @   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_pkey;
       public         postgres    false    1661    1661            <           2606    27683    saldomes_pkey 
   CONSTRAINT U   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_pkey PRIMARY KEY (idsaldomes);
 @   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_pkey;
       public         postgres    false    1662    1662            \           2606    36193    situacaoitempedido_pkey 
   CONSTRAINT s   ALTER TABLE ONLY situacaoitempedido
    ADD CONSTRAINT situacaoitempedido_pkey PRIMARY KEY (idsituacaoitempedido);
 T   ALTER TABLE ONLY public.situacaoitempedido DROP CONSTRAINT situacaoitempedido_pkey;
       public         postgres    false    1722    1722            >           2606    27685    situacaoordem_pkey 
   CONSTRAINT d   ALTER TABLE ONLY situacaoordem
    ADD CONSTRAINT situacaoordem_pkey PRIMARY KEY (idsituacaoordem);
 J   ALTER TABLE ONLY public.situacaoordem DROP CONSTRAINT situacaoordem_pkey;
       public         postgres    false    1663    1663            P           2606    27885    situacaopedido_pkey 
   CONSTRAINT g   ALTER TABLE ONLY situacaopedido
    ADD CONSTRAINT situacaopedido_pkey PRIMARY KEY (idsituacaopedido);
 L   ALTER TABLE ONLY public.situacaopedido DROP CONSTRAINT situacaopedido_pkey;
       public         postgres    false    1711    1711            @           2606    27687 	   tela_pkey 
   CONSTRAINT I   ALTER TABLE ONLY tela
    ADD CONSTRAINT tela_pkey PRIMARY KEY (idtela);
 8   ALTER TABLE ONLY public.tela DROP CONSTRAINT tela_pkey;
       public         postgres    false    1665    1665            B           2606    27689    telabotao_pkey 
   CONSTRAINT X   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_pkey PRIMARY KEY (idtelabotao);
 B   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_pkey;
       public         postgres    false    1666    1666            D           2606    27691    telefone_pkey 
   CONSTRAINT U   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (idtelefone);
 @   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_pkey;
       public         postgres    false    1667    1667            F           2606    27693    telefone_telefone_key 
   CONSTRAINT V   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_telefone_key UNIQUE (telefone);
 H   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_telefone_key;
       public         postgres    false    1667    1667            H           2606    27695    tipofornecedor_pkey 
   CONSTRAINT g   ALTER TABLE ONLY tipofornecedor
    ADD CONSTRAINT tipofornecedor_pkey PRIMARY KEY (idtipofornecedor);
 L   ALTER TABLE ONLY public.tipofornecedor DROP CONSTRAINT tipofornecedor_pkey;
       public         postgres    false    1668    1668            J           2606    27697    tipotelefone_pkey 
   CONSTRAINT a   ALTER TABLE ONLY tipotelefone
    ADD CONSTRAINT tipotelefone_pkey PRIMARY KEY (idtipotelefone);
 H   ALTER TABLE ONLY public.tipotelefone DROP CONSTRAINT tipotelefone_pkey;
       public         postgres    false    1669    1669            L           2606    27699    unidademedida_pkey 
   CONSTRAINT d   ALTER TABLE ONLY unidademedida
    ADD CONSTRAINT unidademedida_pkey PRIMARY KEY (idunidademedida);
 J   ALTER TABLE ONLY public.unidademedida DROP CONSTRAINT unidademedida_pkey;
       public         postgres    false    1671    1671            N           2606    27701    usuario_pkey 
   CONSTRAINT R   ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (idusuario);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public         postgres    false    1672    1672            �           2620    27702    GravarLog_Banco    TRIGGER �   CREATE TRIGGER "GravarLog_Banco"
    AFTER INSERT OR DELETE OR UPDATE ON banco
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Banco" ON public.banco;
       public       postgres    false    1631    20            �           2620    27703    GravarLog_Botao    TRIGGER �   CREATE TRIGGER "GravarLog_Botao"
    AFTER INSERT OR DELETE OR UPDATE ON botao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Botao" ON public.botao;
       public       postgres    false    20    1632            �           2620    27704    GravarLog_Cargo    TRIGGER �   CREATE TRIGGER "GravarLog_Cargo"
    AFTER INSERT OR DELETE OR UPDATE ON cargo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 0   DROP TRIGGER "GravarLog_Cargo" ON public.cargo;
       public       postgres    false    1636    20            �           2620    27705    GravarLog_FormaPagamento    TRIGGER �   CREATE TRIGGER "GravarLog_FormaPagamento"
    AFTER INSERT OR DELETE OR UPDATE ON formapagamento
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 B   DROP TRIGGER "GravarLog_FormaPagamento" ON public.formapagamento;
       public       postgres    false    20    1642            �           2620    27706    GravarLog_Motivo    TRIGGER �   CREATE TRIGGER "GravarLog_Motivo"
    AFTER INSERT OR DELETE OR UPDATE ON motivo
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Motivo" ON public.motivo;
       public       postgres    false    20    1649            �           2620    27707    GravarLog_Perfil    TRIGGER �   CREATE TRIGGER "GravarLog_Perfil"
    AFTER INSERT OR DELETE OR UPDATE ON perfil
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 2   DROP TRIGGER "GravarLog_Perfil" ON public.perfil;
       public       postgres    false    20    1655            �           2620    27708    GravarLog_PerfilTela    TRIGGER �   CREATE TRIGGER "GravarLog_PerfilTela"
    AFTER INSERT OR DELETE OR UPDATE ON perfiltela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 :   DROP TRIGGER "GravarLog_PerfilTela" ON public.perfiltela;
       public       postgres    false    1656    20            �           2620    27709    GravarLog_Tela    TRIGGER �   CREATE TRIGGER "GravarLog_Tela"
    AFTER INSERT OR DELETE OR UPDATE ON tela
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 .   DROP TRIGGER "GravarLog_Tela" ON public.tela;
       public       postgres    false    20    1665            �           2620    27710    GravarLog_TelaBotao    TRIGGER �   CREATE TRIGGER "GravarLog_TelaBotao"
    AFTER INSERT OR DELETE OR UPDATE ON telabotao
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 8   DROP TRIGGER "GravarLog_TelaBotao" ON public.telabotao;
       public       postgres    false    1666    20            �           2620    27711    GravarLog_UnidadeMedida    TRIGGER �   CREATE TRIGGER "GravarLog_UnidadeMedida"
    AFTER INSERT OR DELETE OR UPDATE ON unidademedida
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 @   DROP TRIGGER "GravarLog_UnidadeMedida" ON public.unidademedida;
       public       postgres    false    1671    20            �           2620    27712    GravarLog_Usuario    TRIGGER �   CREATE TRIGGER "GravarLog_Usuario"
    AFTER INSERT OR DELETE OR UPDATE ON usuario
    FOR EACH ROW
    EXECUTE PROCEDURE "Gravar_Log"();
 4   DROP TRIGGER "GravarLog_Usuario" ON public.usuario;
       public       postgres    false    20    1672            }           2606    27713    FKidusuario_idcargo    FK CONSTRAINT s   ALTER TABLE ONLY usuario
    ADD CONSTRAINT "FKidusuario_idcargo" FOREIGN KEY (idcargo) REFERENCES cargo(idcargo);
 G   ALTER TABLE ONLY public.usuario DROP CONSTRAINT "FKidusuario_idcargo";
       public       postgres    false    2055    1636    1672            ]           2606    27718    cardapioficha_idcardapio_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idcardapio_fkey FOREIGN KEY (idcardapio) REFERENCES cardapio(idcardapio);
 U   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idcardapio_fkey;
       public       postgres    false    2051    1634    1635            ^           2606    27723 !   cardapioficha_idfichatecnica_fkey    FK CONSTRAINT �   ALTER TABLE ONLY cardapioficha
    ADD CONSTRAINT cardapioficha_idfichatecnica_fkey FOREIGN KEY (idfichatecnica) REFERENCES fichatecnica(idfichatecnica);
 Y   ALTER TABLE ONLY public.cardapioficha DROP CONSTRAINT cardapioficha_idfichatecnica_fkey;
       public       postgres    false    1640    2063    1635            _           2606    27728    dadosbancarios_idbanco_fkey    FK CONSTRAINT �   ALTER TABLE ONLY dadosbancarios
    ADD CONSTRAINT dadosbancarios_idbanco_fkey FOREIGN KEY (idbanco) REFERENCES banco(idbanco);
 T   ALTER TABLE ONLY public.dadosbancarios DROP CONSTRAINT dadosbancarios_idbanco_fkey;
       public       postgres    false    2047    1638    1631            `           2606    27733    email_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY email
    ADD CONSTRAINT email_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 G   ALTER TABLE ONLY public.email DROP CONSTRAINT email_idfornecedor_fkey;
       public       postgres    false    1644    2073    1639            a           2606    27738 .   formapagamentofornecedor_idformapagamento_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idformapagamento_fkey FOREIGN KEY (idformapagamento) REFERENCES formapagamento(idformapagamento);
 q   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idformapagamento_fkey;
       public       postgres    false    1643    2067    1642            b           2606    27743 *   formapagamentofornecedor_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY formapagamentofornecedor
    ADD CONSTRAINT formapagamentofornecedor_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 m   ALTER TABLE ONLY public.formapagamentofornecedor DROP CONSTRAINT formapagamentofornecedor_idfornecedor_fkey;
       public       postgres    false    1644    1643    2073            c           2606    27748     fornecedor_iddadosbancarios_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedor
    ADD CONSTRAINT fornecedor_iddadosbancarios_fkey FOREIGN KEY (iddadosbancarios) REFERENCES dadosbancarios(iddadosbancarios);
 U   ALTER TABLE ONLY public.fornecedor DROP CONSTRAINT fornecedor_iddadosbancarios_fkey;
       public       postgres    false    2059    1638    1644            d           2606    27753 #   fornecedorproduto_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 _   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idfornecedor_fkey;
       public       postgres    false    1644    1645    2073            e           2606    27758     fornecedorproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 \   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idproduto_fkey;
       public       postgres    false    1657    1645    2099            f           2606    27763 '   fornecedorproduto_idtipofornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY fornecedorproduto
    ADD CONSTRAINT fornecedorproduto_idtipofornecedor_fkey FOREIGN KEY (idtipofornecedor) REFERENCES tipofornecedor(idtipofornecedor);
 c   ALTER TABLE ONLY public.fornecedorproduto DROP CONSTRAINT fornecedorproduto_idtipofornecedor_fkey;
       public       postgres    false    1668    1645    2119            ~           2606    27902    historicopedido_idpedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 W   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idpedido_fkey;
       public       postgres    false    2129    1713    1715                       2606    27907 %   historicopedido_idsituacaopedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY historicopedido
    ADD CONSTRAINT historicopedido_idsituacaopedido_fkey FOREIGN KEY (idsituacaopedido) REFERENCES situacaopedido(idsituacaopedido);
 _   ALTER TABLE ONLY public.historicopedido DROP CONSTRAINT historicopedido_idsituacaopedido_fkey;
       public       postgres    false    1715    2127    1711            �           2606    27951 !   iditemavaliacao_iditempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_iditempedido_fkey FOREIGN KEY (iditempedido) REFERENCES itempedido(iditempedido);
 Y   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_iditempedido_fkey;
       public       postgres    false    2133    1717    1719            �           2606    27956    iditemavaliacao_idmotivo_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT iditemavaliacao_idmotivo_fkey FOREIGN KEY (idmotivo) REFERENCES motivo(idmotivo);
 U   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT iditemavaliacao_idmotivo_fkey;
       public       postgres    false    1719    2081    1649            �           2606    36194 '   itemavaliacao_idsituacaoitempedido_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itemavaliacao
    ADD CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey FOREIGN KEY (idsituacaoitempedido) REFERENCES situacaoitempedido(idsituacaoitempedido);
 _   ALTER TABLE ONLY public.itemavaliacao DROP CONSTRAINT itemavaliacao_idsituacaoitempedido_fkey;
       public       postgres    false    1722    2139    1719            g           2606    27768    movimento_idoperacao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idoperacao_fkey FOREIGN KEY (idoperacao) REFERENCES operacao(idoperacao);
 M   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idoperacao_fkey;
       public       postgres    false    1650    2085    1651            h           2606    27773    movimento_idproduto_fkey    FK CONSTRAINT ~   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 L   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idproduto_fkey;
       public       postgres    false    1650    1657    2099            i           2606    27778    movimento_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY movimento
    ADD CONSTRAINT movimento_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 R   ALTER TABLE ONLY public.movimento DROP CONSTRAINT movimento_idunidademedida_fkey;
       public       postgres    false    1671    1650    2123            j           2606    27783     ordemproducao_idorigemordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idorigemordem_fkey FOREIGN KEY (idorigemordem) REFERENCES origemordem(idorigemordem);
 X   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idorigemordem_fkey;
       public       postgres    false    1654    1652    2091            k           2606    27788    ordemproducao_idrefeicao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idrefeicao_fkey FOREIGN KEY (idrefeicao) REFERENCES refeicao(idrefeicao);
 U   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idrefeicao_fkey;
       public       postgres    false    1652    1659    2101            l           2606    27793 "   ordemproducao_idsituacaoordem_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproducao
    ADD CONSTRAINT ordemproducao_idsituacaoordem_fkey FOREIGN KEY (idsituacaoordem) REFERENCES situacaoordem(idsituacaoordem);
 Z   ALTER TABLE ONLY public.ordemproducao DROP CONSTRAINT ordemproducao_idsituacaoordem_fkey;
       public       postgres    false    2109    1652    1663            m           2606    27798 !   ordemproduto_idordemproducao_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idordemproducao_fkey FOREIGN KEY (idordemproducao) REFERENCES ordemproducao(idordemproducao);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idordemproducao_fkey;
       public       postgres    false    1653    1652    2087            n           2606    27803    ordemproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 R   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idproduto_fkey;
       public       postgres    false    2099    1653    1657            o           2606    27808 !   ordemproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY ordemproduto
    ADD CONSTRAINT ordemproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 X   ALTER TABLE ONLY public.ordemproduto DROP CONSTRAINT ordemproduto_idunidademedida_fkey;
       public       postgres    false    1671    1653    2123            �           2606    27920    pedidoproduto_idpedido_fkey    FK CONSTRAINT    ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idpedido_fkey FOREIGN KEY (idpedido) REFERENCES pedido(idpedido);
 P   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idpedido_fkey;
       public       postgres    false    2129    1713    1717            �           2606    27925    pedidoproduto_idproduto_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 Q   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idproduto_fkey;
       public       postgres    false    1717    2099    1657            �           2606    27930 "   pedidoproduto_idunidademedida_fkey    FK CONSTRAINT �   ALTER TABLE ONLY itempedido
    ADD CONSTRAINT pedidoproduto_idunidademedida_fkey FOREIGN KEY (idunidademedida) REFERENCES unidademedida(idunidademedida);
 W   ALTER TABLE ONLY public.itempedido DROP CONSTRAINT pedidoproduto_idunidademedida_fkey;
       public       postgres    false    1717    1671    2123            p           2606    27813    perfiltela_idbotao_fkey    FK CONSTRAINT x   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 L   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idbotao_fkey;
       public       postgres    false    1632    1656    2049            q           2606    27818    perfiltela_idperfil_fkey    FK CONSTRAINT |   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idperfil_fkey FOREIGN KEY (idperfil) REFERENCES perfil(idperfil);
 M   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idperfil_fkey;
       public       postgres    false    1655    1656    2093            r           2606    27823    perfiltela_idtela_fkey    FK CONSTRAINT t   ALTER TABLE ONLY perfiltela
    ADD CONSTRAINT perfiltela_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 K   ALTER TABLE ONLY public.perfiltela DROP CONSTRAINT perfiltela_idtela_fkey;
       public       postgres    false    1665    1656    2111            s           2606    27828 #   produto_idcomposicaocentesimal_fkey    FK CONSTRAINT �   ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_idcomposicaocentesimal_fkey FOREIGN KEY (idcomposicaocentesimal) REFERENCES composicaocentesimal(idcomposicaocentesimal);
 U   ALTER TABLE ONLY public.produto DROP CONSTRAINT produto_idcomposicaocentesimal_fkey;
       public       postgres    false    1637    1657    2057            t           2606    27833    saldoano_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldoano
    ADD CONSTRAINT saldoano_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldoano DROP CONSTRAINT saldoano_idproduto_fkey;
       public       postgres    false    1657    1660    2099            u           2606    27838    saldodia_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idproduto_fkey;
       public       postgres    false    1657    1661    2099            v           2606    27843    saldodia_idsaldomes_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldodia
    ADD CONSTRAINT saldodia_idsaldomes_fkey FOREIGN KEY (idsaldomes) REFERENCES saldomes(idsaldomes);
 K   ALTER TABLE ONLY public.saldodia DROP CONSTRAINT saldodia_idsaldomes_fkey;
       public       postgres    false    1662    1661    2107            w           2606    27848    saldomes_idproduto_fkey    FK CONSTRAINT |   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idproduto_fkey FOREIGN KEY (idproduto) REFERENCES produto(idproduto);
 J   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idproduto_fkey;
       public       postgres    false    1657    1662    2099            x           2606    27853    saldomes_idsaldoano_fkey    FK CONSTRAINT �   ALTER TABLE ONLY saldomes
    ADD CONSTRAINT saldomes_idsaldoano_fkey FOREIGN KEY (idsaldoano) REFERENCES saldoano(idsaldoano);
 K   ALTER TABLE ONLY public.saldomes DROP CONSTRAINT saldomes_idsaldoano_fkey;
       public       postgres    false    1660    1662    2103            y           2606    27858    telabotao_idbotao_fkey    FK CONSTRAINT v   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idbotao_fkey FOREIGN KEY (idbotao) REFERENCES botao(idbotao);
 J   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idbotao_fkey;
       public       postgres    false    1632    1666    2049            z           2606    27863    telabotao_idtela_fkey    FK CONSTRAINT r   ALTER TABLE ONLY telabotao
    ADD CONSTRAINT telabotao_idtela_fkey FOREIGN KEY (idtela) REFERENCES tela(idtela);
 I   ALTER TABLE ONLY public.telabotao DROP CONSTRAINT telabotao_idtela_fkey;
       public       postgres    false    1666    2111    1665            {           2606    27868    telefone_idfornecedor_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idfornecedor_fkey FOREIGN KEY (idfornecedor) REFERENCES fornecedor(idfornecedor);
 M   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idfornecedor_fkey;
       public       postgres    false    1644    2073    1667            |           2606    27873    telefone_idtipotelefone_fkey    FK CONSTRAINT �   ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_idtipotelefone_fkey FOREIGN KEY (idtipotelefone) REFERENCES tipotelefone(idtipotelefone);
 O   ALTER TABLE ONLY public.telefone DROP CONSTRAINT telefone_idtipotelefone_fkey;
       public       postgres    false    2121    1669    1667            �   �  x�͚�n�6����K$�:x؅�C�,)Ҵ��-:Q'[��Cѷۣ�bﰫ�����nPǶ���#���&�7����E��M)�˲xzs

ъ�^6b&�SPշ����B���b*+�ݲh�\6r9+�+�i|�q��ħ�� ��!� �Q�8C�D��$����j��P��0�P^~��X?�����(��:;#���|r1����r%�E=6�Q�sY�n�fφ>���v{ɣq��侾�}0��;Y�r5kJ5 �F�>�Z~�;{����4u��¤fѨ1
bs�Q {nb'��A�k{�F1�i>����rY��FՀ���rVw]n���
'ϭ�����C�#
��V
}r0y�4��O�_^8�1�7wMiC����y��u����� �����Q(0R6�|n�E�|��J.��Qn��r��O�n*��S���y�Y�z���̋i����)�	�-���;ʖT,��F8^~$�'��;"z,���8O\�-�xZ�O�!��G� b��W���L= #���(M�����0?���N�EW�}�$��%�9����b)I|�@�ڱ���/�k��k�H��O`���k�]y<��G�0Ą~���#n�\�Il��]�f/�S7ktiz ��}I�O�e_�m�
#��0��â��x]AX�y-%>	Aj�=xԫ ��c?=��N�����.gwV����'�%���0[z'���+�jX9tsd'���x��UYȥ������M+u��¦�OK!���3/=�����!��ԑF�_��s������+Q�Љ��B���҃~�#��.��9��G���D�9�.z2���=����*=�t�G�A��I;P�����K��	�tb���������%�J���3b
��n'�c���5��*ۍ��]�f#J!r�og���T�����1�\�FCJ=�p�����Z���p9rq�QO8
\���QMf���%.����'��ե>\�R�+��27�uq��+G��\N��ٲ^H�LD���U17�Y�m���T/󧙽"��5,�����z|�����ᤸ	���<	p'��;9&�g�yǦ�B�2/+%�p��U#�שz9�ۮxY�����O�wi���I4Q�3��P������:�_�ѻ2����Eݖ�z���)��aU!IS]�č���hT��$d.���$��%F�̀�I������vV�ψ�����J�\��[7���v�6��J5d#6{�K�Vȅ,��AD��t�ԔwK�bmw6^�
��ա����HG��Ⱥ�� מZG�~S6/����$�O����׍����J��S��^I9D	�+����x;)�Q=|��݈�E���WA���bWA��LRg��U�[Y���*⭟��I b�V*��,�8aܧ��c1�ǻ[!}j�0�{>z	��/�s���������IT��O�׋p�qr��M�칉�7YLE%n��U+PC5�K��}Sm�=�e��C%�.�_��k��+      �   l   x���v
Q���WHJ�K�W����M�Q�Ls5�}B]�4�S��ӊS�u4��<I�Z���X��jJ�V�`7j52 Q���ر��jLI;���� �gR{      �   �   x����N�@�{?�vN�4�UTH����C��o��o���(�K�kp��1P�nF+�|mݴ�zu�y��Z��
DK0��偲T�{�{����}xz�ZX\��l�ѕQ�w2��zrځE��S� ��=08�i/��8�����g��թ7A�d?\��	E����6�n���R�Y����`�A�`�x!���(w�s�i~��$`�a�18d{����bs�G�B*�$I�"N^&>���̡ӏ}^��(� r��       �   d   x���v
Q���WHN,JI,��W��L��uRK��ԢԴ�����b��'1_S!��'�5XA�PGA����B��P��T]G���@G�LӚ�� �!      �   M   x���v
Q���WHN,JI,��O�L�HT��L�	�(d��KR��2�5�}B]�4uL4��<)6�h
 ��,�      �   ,  x����N�0��<�mm�"5q�1�@)j����%��6A�vZ��ً��~���]��jSCQ�kh��jK1� �6F6\O�>��[U0N�S���,*���9�4���vG���_�иw����a�>>>���	Z/u�w-WP�u��"�Ԓ�����zn�4fI��������
�!�i��K��z��(����ޕ=%di��1���$%��$�!�W�)��aL��$8ľԽ���Ώ73
B~�?P�'8�MK�@�֭A+�0|�z�|�I�94\|R�L~�N+�Q�n;��      �   �   x�Ւ�
�0�w���
A�P�Щ�� �vOcZ�H}�^�nRu����㲢LodEum�����զ�f�N�p�f)g`z�^�h���e08���8`c��j$>�s�7z�ф�~�봄C̠��|M�A�儁�<�3�#1�KBr��$^�V���k�u�_�d�꒮.?�4S�%m�jY�      �   �   x��OAJA��+����xR�(�C Dp��f�ܝe�{���w=�N�E�jCC]TUo����@���:�W7�ȝ"�2"� ��d�G� I< �,����V�r�{޴�\L*l#KcM�hN�q7v��4,jZL�xcW���[Ă�RL�gq~��/�&����
�˾ev�Rr���]WP��"L��b�]2^"��ꯛK��{G����YB.:�����N�ӧRz�0G�����^�VU�B1�B      �   �   x�Œ1�0�w�mQ�`�%:up�B���D$K��O�i�u��{�n�x��~h�#��x-�[^�*�[�4��B��`9OVIA9�J弟�:��6�Y]�k�h(VS LpF�r�	�.E���8��8Nn��q��p`�èsC��J�����`�QQpC	+ǘOn�[o706      �   �   x���v
Q���WH�M��Q��L3t�TfJZ~Q^jrjJ~��B��O�k������zZbqJZ�C1�����u�5��<�5�hj"М�є�f4-+?/�$#1O�D/7��$3/��!�I/9?h��%%6X�ܛ��Z�S���\.. ��n�      �   4  x�풱N�0@�~�mm��J�L�P+��~�g�Ա������I"00���;�-ߓכ��n��~J�V���o��+��T�G�.��I��x�R�d�ɒ�|B�tZz��ʻ@�r��JKrq��T��'��
��T;�na�s���$\p��o�W;�,/�<�PCp%z~(���1�P5�r�5�,M Ogi��	�W��/�6ge��k����/蝠�����jօ��)����8L�q�vַ�w��>q��d��ߒ]�l-�Z�S(ګ�D�J��e}��^�2~�O��F/��{�      �   �   x���v
Q���WH�L�H,IM��LN�,I�+V��LA�Q�L)(�O)-��Q(H-�O*�3s2K3S���Ē���������|M�0G�P�`#KS=dZӚ˓^n0�Q0Zj�A���! @a�Π�+� �aw���0c��)��"6U�`h�%Y��&���� �E|�      �   �   x���v
Q���WH�/�M,HLO�M�+�W��LA�Q���M�Q�/H-JLN�OJ�KN,�L�Ts�	uV�0�QPO,NIS�Q()*Mմ����@�S��if�	�0�'-1�����-y%�SҊa�B���f���GAv��.s�]�F�ȈVVY �rI-�\�	��~X����\\ ����      �   
   x���          �   _  x�՗ˎ�0��<�w�H�C��B#*Q!*f�g�8���R5���Q_r%��6��I��?~�cv����	��_��EAc�p��X�^y(�	�p	�.y� S��5�+d,X������s.���*n9��w`B�%�P���C��괤��Ӣ��`����w(b��g��ٿn��	{h���D�SX�a47�Hp���M�������)K��񼓕D�QקB�&�AC�	���J�,=���{� �wXg^�{�X��a�Yhϻ#6;D�i��9��KϗZ�H��V�UJ����n$�:ꅕ֫e�ԧQ_��7�J* ��#� cirJ-��92�^%k+L����O�ݘH����߬s�AT#'�*���r�Ek�*jld8ɿ��>5u؇G�O��8
�Z�Kuh1w�d���;�29�3ӇVђ�8���[FiJr��L��D\E�}�x�%�|L�n�85�Dg���lv,��R�E[�s�4U1����W�����$\��:?���
� Tw02��d�p�N�s��.���l���ju}@�r%+��)�b��ivA�@�]��IE
���ia0���$U�������DM�t���vJ��#Ѽ��l��wG      �   �   x���A� �{���*�`f��i��h���#mtX���?�I���}���Y�Myk���+�ڌ�SR��h���A�	rw��:�;��U�I���z�/�0��1<N�{�@�	$����&�g"t7��cP�af�M�����t��Lq�5�E(�H2C�,Vd���	9:�2g��q�}�7���!32�˽�o9�}I�      �   �   x���v
Q���W��,.�/�L�/HM�L�W��LA�Q�LA��3KJ��r)�%�h4�}B]�4-u�Luuԍ,tu����L�̍M�5��<��#�{�����@����.. �]Z)      �   
   x���          �   h   x���v
Q���W�,I�-HM�L�W��LA�t2S�XE�)�%@faib^IfJbJ*H�4���K�Ts�	uV�01�Q02�Q��Q040�300�Q0մ��� �%�      �      x���ͮ5�q�羊wf�6����(;��G�c���W�{��\g� �@$Azw�b=U������O��������?��_��������ۯ�����o����ן������m�����?��?������O���_�?��_��������������_���8���#�:��#���1��H�w����������{�ݯ�������^�S�b|�2�?��G�q���8���H��3�8�+�� ?V>D8�w� NHx:G�;����_��R�o��j��Ϸ&m&��3����s����D�iҼ��פ��N�4_��s>p�?�������~�AM3ߘ��mi��&�W��sE HR�ԯ#��Q�XL��|s^-l�oP�ܾJ}���;�C����N�\ޚ����:f��>Ԩ����+�������(<Kē����Q�h�����	 Q�'�\�yi�6;�x��>����f\�J�+�%�3�%1M�8�磙 ��a��|�W	e�h�A�����H�� Q�O�_���0
O�f[���[�$���q�%��$�����(����G�%�W<�ǧ$��F�
�ǣ� I�&��C��G��	��1̵�+g��!nw�I��h^�c|.� Q�����>F�>az�i�W�����{S�p���떥�.��=V�R{�K��
�o0i����Ϭ
�MM:��pV�a�I�����٨��E��k�J�3}���	��P�V��F���$�z���dm�꫌�Q�KT�����[��򝵁x�t�$���m$�;sD����_�hC1�{����� E�����y��?u$�g�R�K\>�)�@������YE����s��m�:�q
��y� ����s�w�yTخ
E�'M��8����p�/M{��U�a� 3�ʏS@�0
�U�P�k���(�0���pj�0
;��r���
ðфy�:f��n%�0;�e�{�?a6�x|��z��wb��(<
�`#��S�*��*��Sq�y�9o�8�4s^)�iԁ8|ߝ<u$�G��^%^q ���I�5�_TS�4���U?���h�0<Y�.��̦�)�=�ؿ��0<i��}��,�4i�{�YA@���8?��uL����H��a�����fuiMC�ڣ�]�'K
���'#� i_qn��g�H�a�̽9����0���∏'39�4;�<��9�K�0hp3�:�g� ]��25Ҫ��¹�x��_�PG�<� m�3�d��0RYs}ڟ.�:�65��C ��F��Dg��C��.���]�f�m�o�Y����ve��
���&�Іa���f��/�6�e�<�����&���̣yҽW��U̇0����;�G���H|���q.�0|����^�O$�0�8%���C����@!�]xC����XQj8����I�Ut'9����)᭴���ñ�ء�U�^=�9ڞ�q�t�O�F3w���� ��.�67�L�2����v_G�(�Rw�T��{���1�Sg81�u�t$}dR�;�|���~4�Ww���L�;q����/��L�s�S-�-Uq�X ��uN�"�dj݅�Q�ԎO��Idn�N:�G.���JCq����"��.���>)�2��©�qm>*#�ڀl8i�Q��6 ���zx��N"��N�\��o�x:ڀ�`���:�c[j$2��;����L���>@��]8���*;��? ��vo89��L��p
���e 2��>uP����_�^�B�.$؈���;�(|�M��5���[���D᛼p^����79�nMG}[�>�cr�jZ+gyv�z�8�g/ #Q�w'�{�Ϡ��'��EnʃR�+g��`W�A�ߕ�lO<���|��p��w�����t�;�j�w�^Y��r�QY)�U�=�5�Ki�U�Z��RjxeU����5ESet�K�P2(M<�ih�Aj
�R�3���!�Ti㕳�^���:��ؕ#�b���j�6�$w�F^�6`���\�)�<�	�V���|���8(��E�V�� �DSMJ-�q2Π��um��D��9N�q!�J1��)e�y�I�f��Tk���AY��8%��R�x: Q�y���:��e����g��^ ?���3�hG��!2���dSA�E>ؒ%4��&�:`'*zN.tZz-X�.k����p"�lAzz�"_�j�����(H�����p"�ʑF�A(�� Ҧ,1(��N�.2~�h�rE�����{������t���p�6�U����ӑr�{]$�=ǁq_�|�mT��;G����P�s�ҿ�|<mT������@��hJ)s�9e���8�z���������TB�o�k����I�߅S]A���)H*�,�P�[8͚�<�O'j|Ƕ;,m*��.�yB�=�M��3�e�	kQh�9�����&�X���Z�|�����6��A����B�o�X$��(��.���x&*�$
u��c���1+
u�'������<�ηp�ֈ��:��f�dt���[8eh��Q(�9F�ķ�:8ꨜ�%0�*�N����E�зpZ���=G+�:*O�Y��(����!�GQ(�-��Wy3�$Q(�]8!��{
}Ny�U����	�����-t�J}�z�<E����Q��{��ɨ#r�u���3�(4�N�n|<uDFZp7��H���p�^�}�G�~6\
}N�1;�>ǉ��H�C
}'}��?p�����O�Ϭ�(�����1J�a����y?lu���.��%������zV�I�C�pByk�������S�*�}�=
���c�oXjY�6��`@jY�X�29�	�,�I:ٚ
��E3L�~���R�E��Y@�R��Cqx��t?��?ژ�8�~�B)����-�tϺ6mL�������c~�&��(���y���6�Qhe-tG��IZY#Y�{ZY7�ظ�F�V��ɰ�h�F����x>De���p��1��B)�I�y��R֢1E��9
���c� �$Q(e]8��*�(��.�y�IJYN��@,��'۴4�F���p2^���^�$
��'Ʒ���t�19��7u�F�Rօ3�,��JY��XCq�Q�մ�UTZY�S�Yf���r����B�LTZY'���������������Z�`�ei�r�:��i���F�Q#XB�͚��2�h�8Vz�����1@�R�:ir�n��e8鰮���0F�R։�w_OG�g�:w���tpѧ��N�\H{��t��&�YӳC��D��u���Ԩt��~?��O;e���8�����N�I�a��<H���r��7���J'�ęO�1��@�R�2���c)\���8	�˙*��g7��H�R�2�b�6q���Rɚ8����I�)�,�1j�cM��T�JVb�I�dNB��\�IR*Y'Nɤ>/)�,���ud۞�F��dt0~;�ݿU�mP�gA��x��F��t����|�S�G�'��\���Q�<К�t�MJ#�p
n����$��u�M�	{0Iid�8��S~���F��$Ԃ*)�,Ǳ�Տ���$��u�lP�LI)d9N����`R
Y��l����H�R�:q0A�DA���8+��b�H�R�:q�K�RȚ8	��c���l$I)d�8H_������Mݎ�$��u�d:�;)�,�)��f��`����N�RYK�����Z���� IJ)�q 5OG�m~�7��$)�������(�,���^�G#Q#IJ+k�dk)�Y�WRN�r����.�$)�S�8ssJr�I9��ql����$	�S-��!����s�+�$�B����1n$)���V��B��T�?��IR
}��-9�)�>��虒�+(H�R�;qrac��R�s�b-�W�F��B���H2�!)��'��@�R�;i0��k�F�����I�Ii�9Z�o��IR}'ֈ}�^R}�Ӿ;���)����j�XvGi�9���� Ib��p
l��F_F�����8�\�2��e�H���+6ǵ�    t���+_�q������b��`�ȑ^׈�>ǩ�� H�X�+֓�_���>�	��z=�$��g8��ڝ$v�
*�BcGb��W쪯�:�$V��QFڔLJb���>h��L+}Ŧ5DR6��F�^��)�Q�F��F��`>29�>tR6w乀6����*١Ol��t�\���F�"M��a$Il����@$���4��&�~8�(��>��m��~��|�.֎�3g
�$�������I��U��r�-����6Y���5"�=��WmL��l�e I��9Mcbj�|3P��ո�"�V��0E��|[�?��4$���=�,#IZ�/�q��@IZ�8	',�J��|�^�0jrS������}YP�ɭ����@���m;^Og�4(����g��������6$I+�9N�� ���fF��yuPz��b������I��9j�?G)H��|���odӮ��@ӑM�l.@��6p�c!u�Yk�Ŵ.d�N��d���8%����x:҈�����we Yk�9�ܗ�|i��|����bn$Yk��>z5�1Yk���\��d��gsP#C�^g��W�	���nK�A#�N����4��t�g�V�]�e���8��^�H���;qf�!} ���3�p���sʑ�d��w��v2Y)�9N�E,aLv����Vw�X�J��q:."�fG)�ND;?V���2��$���6��2_YM���n��R�+��r�l�mV�|�3P�L�de��g8�� ����4i&"^f��WVGSdR�w�Y��9�y�l�R�|e���Mo�J��q:�����F��._��b��B"aG��M����\#��XГ�H�r�N�m.��/K��9��K=�g��H���;qbzdAW�|������ {�T�N��^)noղR�s\�%��t�SV�|'RM{�1+]��tT
>�d�$+]����mA'�^Y��9�M�|f���c��D\9��hV�|��KP�id��g8��MoA#�J����T�T�&N�܉nM�.��$�S�kY��N�69G(]>��h�Ʋ)J��q��cw��g8%��+�wG��9�͍ ����s�b����$+]��ۚy�)��+]>�)6��1	�H���3�藲���t�'��c5+]>Ǳ�Qİ�J�����e����嫫�b�<���3�l�X�[��9NE	7�擕.��`��A?t���8Q�mN�2���,6����N\א�R�kvM�eՇ�`$Y)�80/ه.���,1��yF��6߉V���6���;�kF��6߉S2�
��6_;+��H���;qmS��6߉�s�c��d���8&���G���8ֻ�`������;q0Y��;�P5�S�$+����w�JO�J��ę��\��ᨣr����ogV}'��;2��4�N�D;�e����ҦF+��F������:*#�76 �J�更}I�YJ���);  Y��5�>�$7��(}>�񙩏qF��>߉�"}u�>��`:B}�Aw?�d��א�>"�v#��'�L�h�e$Y)�N�E�$��F߉����IV*}�c�yY�B��9N��)�εA9�I����3_ ��T�.���c?SQ*}�Sp@'��R�s������(�>��$�H��T�N�rlz�IQ*}�P�B
��R�;q�9cIQ:}'N�Sǋ��k��*�⢔�ںҟ��N5����N���#E)��8e�.0�����Z���fE)�9NCi�x<IQJ}�ӱS&]QJ}'�#������.���C��R�s���WrK\�R���4���j$E)�N<�rb�2E)��U��M[p#)J��ĉ��/J��q�qm&�IQJ}���������s�j���+�>��?LX+J��pR�~񁣎�Ɍ>2��(�����̍)��\�F߉�˦��d��w��z�ۿ?���4����\)��Uw4&����V����Y�Q
}��d��-يR���kn��%�FR�B_?;q4��/J��p��˛�FR�B��$uH�B)�9�ev�%VFR�B��D�I�R)��Ո#��t[#)J���V�F��w�ķ����A�B���_��dVAT�:��	_�g�S��(u>Ǳ)d�����Ʀ4o{ )J���I��aQ�|�Wc3��H���;qPe����2�����do�2߉�rt�V )J��p��:�U�2��̌~�|FR�2߉�2�v�R�s����S1����N��oڕ.��$����A*Y��9M�)��l�T�'۞�%��*��d�7���R�s�NZZ����g8���H#E��9NC��م�H�R�;qh���4�&M���s��цd����+J��p��94r7�4�'g+�$����8�)0mP6�z.���Hi�z�$��R�|�c����������������M�����w�ʺd���m�Q����"[�"���<�LIQ�|'N�ZQ�|���r�mP��O�k\P�"��X�E�Tz|NӱQN�H���;q����t�e`[��u��(>�IVXEİ���N��S"��(%>�	��Xٙ��;qbߌ�2����'ZHr�QZ|'NXOC$Ei�8)�M��x:ꈜPi�z�
 R���$�4Nv�J����ְ�~:�J��q2��Y����Ȥq��IQJ|�p,(�K���"S)�*���ae�v�-�B�o��%�=CT���8���>��IZ|�"(�3�Uh�-����s���T��w��4SZ|�Ϙ�O��.(/�����_J|NS����bU��� {���B�o�4�	��.���s���yo�a>p�!�:�^���A�i�~
��c���yR�
�E���V�·p���y8ڐ|��a{�·p����0�*T���d�-�B�o���Nش�5�*T�����}w�
��|������hw�v��
5�g�HZ�
5�����=U��-�jOg_xQ����E�[+���i���ʆS6��
5��ӱ5��W#�B�����.�
5>��&;���
5��cG��%[���`BVe��ŷhN�ϛ##�B��/2[υ��1��=4Ij|�S�-�u�B���)���
5����:��U��-�b/�1Y��-�n	�G;g#�B���g%?�6$'�j����T�Ʒh�UW��\��-���@�T�Ʒpl�"��U��-������H���8��Q���6�U��'[��㩰Hj|�)6�fq��B�+yمc�T���:X:��ꪏ�#��'�<쑋�*t�n�q����
[d�����%ŷU��9κ��K�U��-��7�4ިB�o�XOr�EJ|�3O��9�H�P�[8
�΅��(�{�3IJ|�S2p�)�B�8��!1G(�-�y���
�P�p�D�Q_j$Uh�-���1�Qq|��;z
|�+�.q�*�NF�qE�P�[8�d"i
|��^a��H�P�[8{�/�
�����`�CB��q� Tz0|�ZK�����p2sV=$4�N��'VU 4�'�l#(4�N4������qQM��*4�İ]	H���p~�2*|�ۼ��`�*T��Ȱd�P�[8�㚝i����hX�
^��±�����FR�߅3w�l	j|��V�,��w�$�f	5���qq<�Ij|چ�����8���N`Iz|1"��F)������x�sH���[8�}�
=��S�O���FeǱ����va$U��-���������&j�a�2aLv��^�)->Ǳ3(�)7���8fE��^�)5>��cJ�E5��g8U�����4����"9�X�����bRľ��)5>��x�I߳���'�W��J������V4��w�̧3�#iJ��q�VkJ��P�u�	�B�t�&�@U��ﱚR�sk�G�o�R�s�9��sSJ|�3С��7��g8!�)$3�R�3��]�4���8�ʽ�G���"��QS:|'�<���֔��4��"{���875�\S*|F���ݪ5��g8��GR�s����/n$M���_�ҼDF�4���4�^�}�ES|�cir�Q|'M	��LS|���������Mi�E�?��綛R�3�l+D(|FҔ
߉�QB$�T�N�y܋�8�H�R�K�%G�Cx��<aL�p��h8k$M��8�����    Д
��X���1��H���s��Di�S*|N��'�eR:|�S����J��q,�<�~AWJ|�S����{)>�)H��+W�d�`�W.�Eֆdki�k�G��5��H��	K����Έ����R�KK~�O�F�t�!9�"����3Wj|����y�$OG���Jh�����_Z�y�g,r���N��YV`$M��8�'H�|J����}2H���K� u�Z߇A�Ǘ��3ߝD�|J�/-�gn��Wz|���2���_Z�:���h���)(�,���R�s�A�@�*����E�[Sr��T��R|���S�� H���;qг��J�/-�(a��~��t��2�R�����8	�̞�:(���N�J�/����Ҷ�)]>�AAp+ͻ>t�4���8;wV��t��5o9�n�.�)U������'7��g8~$fu�J��q����q�*߉���Q�|�S��YA�*����^e��g8�z<��IS�|iy�GVP�ʗl"��C`e;J��qp{�?tmT���8�>�) iJ���)T?oJ��qн�<�~:��)U������*S�&��9�
Д&_����?��kJ��p�GAr$V�|��＼�]o2H���s�d��-���s���`Rդ�����ImJ��p0̑�XJ��q����׷w��g8hLN��T����e��w�ʗL�i��Ч��Cj�q��� h ]i�4��v�ȗ�o��\m$])���])�8�E~v�6��4�үy�8l�03ҕ&��$�|4u0��4�Nx��#_W�|�c��#d��+M��ķW���Hcr�a��P��th$]i�8�9G])�9MG
��])�8��G;p#�J���A�����J��p�2{u�19���?Et��w��W'=b`4uHV1;+���8�&Ȓm���s��+�g�&#�J���A�i�2�J���)}���H�R�3�l]��ە2_^5�!l�d��+e>�Gƾ�W�|ي�m��sҥ�t��g8(�/L.�J��q��p���H�R�����}V�+m���t��a��0(;NC�<rڕ6_>_��ݕ6��ddI
�+m>�)���ܜ�����h�׮��b�Ei��`���9]i��5�!f��S�|y�o��I#�� ��T�N�H��u�ʗW9yaj~W�|y�o���-u���8v;��Fҕ.߉��0�:ʮt��ۈq�NV�|y���(�͏�]�R��k�E첺+e�g�?�3���+e>Ǳɒ�UzW�|��ll5�*e>��fF<�� �J�/�
VN>�,2s�+e����Ò��5��t��2߉��3�t�Q8�����z?��?Ҩ< �t�2��`)������#�����`�I5])�8ع��"����N������R�s��\
��Q�|يvP��(��+m����X'XwW�|�cɋͩ$]i�8y��׮��'w$��IBi�NIH�?G�IW�|'�K��6��@��w5J��q�;9�"V�|�c��c���+m��m&���^��J��i���>saLv�������ᦆ�)�2��tAb�u��g8�ҦY��2��X���d�i_�NK�J��ql=g� J��q��[@�2����)��U)�9���9�e�R�+(v@eg�����8�,�0P�|�c��ɔ�������^Pi�9N��u<��IW�|':;�ÎR�s�fc|ț����m��Q�|'N�o������R�s|�t����g��+�W�|�S2�;�2Ki�U.8t�J��q� A�����+��k���F2�6߉3�}�e��WVmgou���I����?����WV��ј?�>߉�m����F�h%h���~w�h�����mT6�y��}Y�d(}>�1囜����3���)��J������{'����P�|'N�,c0�>��$�`�z���#J�np(�>�6�r�mJ��p���!�����ZS�,�P}��߅]���WV�rIt��T��j�[��T����x:ڨl�G3w?p�Q٪������ʪЛS�F��g8�^�'ܯ�$C��83����
�v��5�6���|{%��6��DK|=ޜd4�x��{52�v(e��Z�_���&Y)��)8V�6�2��Aܦ����w���0�KJ���>���:����8���Y���B�B)�9�5@c1Y)�t�L&��������X����'_!�k�����&��C���Hw�J��q
�O7�H���;q �+���8֭�ܞ���8�s8�>_�^�6���ڕ:�ES^�QZ`$C��9�Mi&�χR�;qRؔ��P�|'NN�BV��9����c$C��8�3?(u>�񛈃du�:��$k&�V3�:_Y-��)�,�J����ΑUp���4äf�&+m>���N/"�6��'����d(m>Ù��c�;5���8M�YjGi�9NE����2_Y2��R�sk����R�s�� Hv�J��h�1��d��w��㭳�t�OV�|��p˪��*_C�i�ȩ�����&Bz��7��4���R��BFi�N���d^�P�|��q�G�ݡT���ڈ�.�.��tt�'�U���s�9�j@�.��+�s���8&4����s?b����k��a]��z�T���a��S��9��.HG��T��5��C��u�|��F��9N��-YJ��ql*2;�+U>������3�h��w�4����1�<aH6�QB���4���>�mv�&��dӫ��\i�uSd�� �4�N��>�:d�d(M�~j��Q�|����J��q�0��C��9���!��G��ŵ�>M9y���x�����P��g@3��ʬ&�66Gk�LP����l@3:�N��G��q�.�����+�D3�G��E�BN�G�M=��1�¡�����o��8��l�G��N�R��k�H�lD��цg�qd�s�<��\���>O8y��٧��l��r(ݾ��$��цg�O�+��Bi�9z���@o?X��� ���5r��R�3�X,">
�ʡT�(U�ȸO~Om��n��XRJ~Ɠ��G��r(5�(�����$�Ѩ�o�!�j��#�n`��C�_(�R����k��<��<y7�b�J寯����C���<�y�%_(�R��̔��v�|���h�)?LJ�<��<vEI��J��y:����q�J�ρ��H����蓧���}{@�����>�\Na��n0�|ąr(��+F�T�I�� �h<��Y^�킔�@���/Y�����A�����h�M�&(��&`:�����2��������1^(�Pt���"+��<����sS�;�ʡ���#�/p0��0��x�iT����C�^<����w�"��3���_�J
�xJ����9�P�xYS]vw����d�C��E�'����&�(@�<��������*5�(wV�2y��X.�������Ze��d:�;*=�橨Q�Y�x����������b��h�����g�\�|X|V�7N���t�ʡ�/ �a���%�x*6@��I8TY��Yk�AJX'�6:��~��R%
�<�i�ިL��'�\��w�h�s�������G�
�R�9_�-���s��P�� ��pD��U����g�	h�U�3�i(�J|�_<@� m<[�W�o�0BO1����#�����P1dAUi�7��~,��-�7x�`�|�*;����������K�^<��xBb��4@�E;l���T���S�mW#9����� �'��H�3��s�����g�Dj�YO�P	�7�_�l�Uፓ�C/�Bx�X��6�*���|�`��Ex����cS`(��#|���>k�s�;Gd<���
�1t�S��7OC���������F&��T��<��l��%�y
��+&��%�yL�ٜO%�d�w���_A��� ����w���	o��xv�*��g�ѭlP���]�ȅ��J&|�I�{���U�h�W!KjPل7�ǖ��%�t�T�?�5�t��f���FPل7N���;��?���NxUܩ��Y��<֬�젃�&�q2Ѓ$�J&�x�z��AdA%.kS����l�Ye��"���K%^<�@���L    x�$�@->׋�@� �,���v@�H��F��j$�T2��ӑR���htCI�_�}`*�����ɸ=�+G	*��h~��T.���m�Y1�\��+�3�J%�x�	#G��*���	�w'��:9�:B�;w�{ �Jx�XÀ�l�(A��������L��i�9JP���@�#�/^��8���]�Ix�T����o(A���=ٱoi7y�!:�����*������Kkf��p��R	�Ud	9Zx\�9JP��7P�BC��%�x��ʔG��r	Qt��f�h�K�T榃�9T*�S��B��4	�g�,?�R���'|Y��[�~{,�T	O��_�]�(UB��ԫ�1�P��%<���Ɍ+U���݋�]���Lx�OlT�	Rʄ闍����;JPڄ�
~���	��������Ɏ���z�.a2�ۊ��%������	�U���{2�L���:ϴ*eB��t+�wQʄiU�9H���&t��e߻R&L�*>�GTʄ��
�)�VTC	J���F.w�>��`�U��k#�]�F^��>���Tf��Oh<�k�W'�SP��iM��χ�5+}´�RSەC;JP��'P��nW�O2�{W�i(A��@s�H#��'t�D�/L�Q�m-�Ȋ��	'��7O<J�0��"�ܢ]P�R'�6(���AZ"�N�<	G6'(uB�A�δ�AP�ƃ�O�0>g��R}{ޫJP
��p��X��R(4�fI���P�<6r�`� }���j�s�7��4
O��_G%gf�Q�<��eӻ'�6B�<�lEU���M�&��R(<yJ|�g[hG	J�0�aJ!��A��<��ҟ�*��Na^��!���]�)Xl�W:��(��7��N���������(Q)�@��}ţ�)<y0�6<J%*��k�ActT:�>����eT:�>[7���f�(Q�Zg��>��J��x��2>w���R�u:�L�HctJ��Xә��6��%
���eX�l��V�ŃN��]��D�Wx���B�0x�%���?�.FO���ȑ�B�p�������d1Z(. �YF�Q(.�ߴuvz���Yߦ���`��
c�	�;m��b��`�A���(�
�'c��n"��D�X�@M^� �G�1]�Re,W�^��8��-�
�龥?y�:�������hk�ȉG�.�m�6�Qh:Jk�+�[�(4
���[�(
�W%zQ
�΃.�����B��y���h�JF�E�O�<��h�N��b	������N��B��2���B�Ix�w�$%
����W$��Q(.;.7��
���Ҕ��'\<&\O��Q�P(���.��D���vϕ��B4x�V%��`/�.D/<�W$�U�M�p��x���.@/�bB<���P'ts8���K�c�a����x(�	��5���&\<<���L�<(�l���w�L�<���.`���g�I��ƵQ�.�j�W&˅P%\<�գ��#����qB�p=
U��c�����*�����B��G�I�x��gv�������&������$\<�����R��m�
1	��$\<	�FL�(4	O�z���"���� ]b�P$�<8�q9��P$t�\L+bw;B�p�Tt�m�.���&��`]bI�f���'ZF��w�&���ֺ�"�B�p�Tܝ2� 
EB��� &7���Q�:f_5:�<
=B����`sl�P#\8����g�G�x
x��5B�Iv���,��gnW!=��w�F�x~�zj��S��}���P��#��n�;+mj���&�7Z�7�<�Gs4G�B�@&�����L�Fx�|��{{@V\'��i{t=j���~�E��e�Яe/
�W�FH�:A�ƫV=ҽ�� \8V�Aw�@�<�`����d7)�wl���f�iXۙ������?]���<��!�~Ih:��r�+	���3�A	I(:�bS�;	���c����}��sZM���eLBwp�dzY%[�����XxNBup����x��9�8'��OBsp�T\t��"	����Б�:�^'IBqp� �Sё��>'�7�x
��X���`̧۝��'	�A��_��g�6�8��3Q8	�A��h .%�5�x�W����y��#��$�O3���P��?�:6����$e[>�2����^�%)�N�8�4��$��IE�&%)��NӪ��}Vֱ�fS������-�m
����>w�+�+;6�E���l�ZE$�oU�~@Ձ�VJH�����t��}N�R6���+����y�*lRV��8����f�Q���-���0^��&e)��V�̜G��:���R��*�ZQ��lST���HIY��<���/)+ٜg`�M�*+ٌǧ1���%)K�N��������y���OR��OF���G�Q�Q�Ϛ$e-��4S��;h#I�Z6�����HY�V���5+�M�b6�6��*�ٌ��ƽ#��h�`��+�e-���L��$e1[Y��b��
����xb�V�CY��<�N�lC��es�a)�~)Kٌ3K~ذ*K�ʩ:4ک2)��ʩ:dzã�fs�����VV������^ax���uH��O��lՖ��VSe9ۅӶ�CCI�z�jj\��!K�*�ٜ�o���,���7r��'+��깚F��fe=��qT��EVֳ9OA=I"�{Vֳ9O��;Y.��������=36+�ٜ'Z�gʣ��֕�D�2+���2��7��泲��y�Mh�'�����������,g�k����9+���;�=������.h���de5[]m�l�0��g�:���������U�c���de9�	4w4*���N8����r6���V�y�YY��<�z�F�YY��<�v���=�ǋ7XuK��_<��`�Y��tLDy����CO_���Y�9���9{�/�f�y��K��g�n0�U��y�����0>Oh���Xea#�8~��<��&�q�{���Y���5;�
{�;O�l�O��w��.qo�սW5�,l���5$ uZ���=��i�����Ҙ�@�ؼx�'�;[�/��:	6$[�/�1�ꐲ�~��h�I�ݳ�~:[bäf߻���Ȅ���,쀿x�i�v�w�`�z��-�O��.�����h��.r�����0=i�W��y��oȄ-�OF�gVǖ�-���2��T�PLg��a���{�h(Y�N TJ$kJKrcBs�q���[߅����m�,T����|	���=!M���L�9�<h1�y*\(:O�0�ww��e��\��j�Bċ,/���.��d(Yf�@�
�*3O��j��e���Sq`���r�,s߀R��y���OgO�L<Y�a��Q���:,���Y�^<͢YMe���S�t�,�/�nRAb�G��UDZ��e���S�a8Kʤ��g`qg�N�I�'O���4Y'�/�����z�2g��x}hnU��<�L�����9X�q{�<�Ȝ��g�����3x�$k`Ns�2g����E1'.˜����N���e��Ń�e��9�'�����Eɜ������ܪ��x
�DY�,s/sN�3�e��Ƀ�H��g�9���3�u~2g��H��\�L�x:$4��/ˤ��gXX��ˤA牸;���d���SѴ���d����m��d���c�i����g���J�e��Ƀ۝B=�"�/���*��)2k��x��O�Y��Չ���"�O�d�Zl�Sd���cu�lXd��œ�6���5x�¿/u|N��6�Ef�<�'iz�ȴ����]7���6x�` Y���"�/�h7;ĳ*2o�Ɱ���+2m���?$�Ydڠ�$�@����b�Q�����) +=,2m�ⱞ$����U�+��![�h���"�/+&a��E�����ȼ���#>�^�^8���h��ȴ��]�߿���2�"��X~l����<v^.$_Wd���3�|���tT�.2E��<��Q���ȼ���"��/m|��� ���d+2m��Fk�L�x�i�$�Yd�����:��"s/   ���*�n)2w��	�S^��h�sC���,=&S/k�ȟ�6<7���h��"SO����L��E�:O��2UO�L�x:T"VI[d�����h�W�^<��c���������Wd���3�����9x� ;�;P�9x�D�q̶2s���x�9Xd���S�c����x��˩��x̌c�uEf�<��r!3/��j6vڑy�'�<����lȼ��J�Y�F�y��3�k�<ʼ���X�g�Z�������\�k���'O?]�ȼ�'�m��/Zml�ٝX�Ek��4ϼh�A�tXI��38qP(1��l)�:��)֔�],k�A���i�M�*���c��/޵�`������#��<+t�'M��Vİ��	l+��������h�A�T$6��Y�ڠw㏼IA�j�ލ�&h��h�$�=���Zm�{��뢴� x�S��h��h�$yPo�h�Ao�7�z�ౖ	t����S��'��Zo�'B4���z���.S��g E��Zo������7$���P�z���iP��ǆ	3/�(���<���V��`\�^	��_�ƥ��ׇ&�`<5�N[��6MCK6��m�ڠ�+�d�1�6�<���G��u$�KPj�qi��{n�6�<��!,��l
#��ڸ��i��U�ƥ/��J]�y����q�Rt����l�Q���񤁸C�P����l. }�a9XX�+��䪴�'�5%��W�-h<6(�f��t�b:����9X!��pU)F+ޏ6���H��\F�j�ʛ�p��R������5?�J]0��b�U$U�����,v�\����$���Ū�t��X�aUʂƓ.	X�ZUʂ�S~��JY�ylj&K�W�,Q�����(Ui:O�)�5#�J[�yf���G)N�tFnU���S�sQ������U���JW0Z���].����$�ǒbU�
�51�D��P�
F��I�Rf$U�
:OC.���U�
O
�>t�R��q͕��it���4עt�'(����t�d��Xx>]�����K��;      �   �  x��V=OA����	J!pa)�(@*7㻱��n����0?Q E��Ҥ��ޙ��&ʺ�n�w�fޛy3������^��&�q.?�a��P���*��[�6��ѧ��9l�{�~���ypS6s?����;X0�-�L��L&<�X���&�<T�/R%��ב��{����6���v%�l�X5��j� ������qᘉ�b��5w��$3�36� �h0%&:�60i慳�K�9��6��������@5f�e��V�8]��&3�O@tST�\��4�au���b��.#���Td��$R+-,��#V�Ve��<�����;�0�)�+*���`d�X;��#�l a��Z�$��<�J$�d���m�*Sb�O����w�K1�>!�fF�0K�w����k'��+V)��������6��(��L��Y���Vm�PT�Ģ���_��8�b�WM�*<PE3gI�@�M�S���B�����u432>H%UIAk�ْඣH���:9#�~�]�Ua|K���{�Q��1����.؎K�3ZH_����X�+g���b��̦hn��U9g_=l,r�ZN2�}42s��4��;� ��A��q�w97$��T�&��@F^�ꎝ��yd|�I^����a��rs��A�JoT��=IXv�`����dZ\v^Uc��mEv2��e/�ܝ�oMTt� ջ#����!�W�t�veX�լ1�omxL]g$V�A��v�˘��엓�wXkk�s �      �   �   x����
�@�O1�
�XTtZPA�ּ�����ӧXyׁa~��OR]2H����y2,����-	(мЭ ��k�`��P���
��d�p!�Ī��!H&Л��a�w:ѻv*�A�yԮ���� ��h��7�yf�}gG��
�d��O,�y`���c�z�=�J2��NA����      �   
   x���          �   _   x���v
Q���W�/H-JLN�W��L��uRR���2�̲��Ē�"M�0G�P�`Cu׼��ĔDuCMk.O��3���l�.�8.. i@2      �   
   x���          �   
   x���          �   [   x���v
Q���W�/�LO��/JI�U��LA��(��'e&'�k*�9���+h�(��&�&�kZsy�o�� �Ғ�����0..  �0�      �   \   x���v
Q���W(HM�L�W��L��t2S���R�SS�tRKS�J�R�5�}B]�4�Lu-uԍ,t���L]Ӛ�� (��      �   �   x���]� ���+�]v1���jЂA�h�{AF�J��O�EuQ� y|���,/�}	Y^n��e%�0̭hښ@Y-�����>��!-`HPŪA =+�/��wZdh���{q�#��!��8p�"��Y�0�g8Йm�#p��kcH�%���\i�s����m"e��*�^;�D�s�g]2w(-�I1��ȶ?y͡(�H���@���]�!A��&)Vf,���*Fջ�=�����      �   8  x����j�@��~�=&���GҚ�z��h~�)M!H)y�kg��^>I�O������q�~��߷��z������Իv�o����yy���}{��*��ǯߺ	E�����;�k�F�j-�O�F�V ހ;*��2��˭���X�/6�PnTn�r�r	�-F��@/+[_Q.v�����9K���e��&�b�y���#z�_P��1��&`����X�b�&3S�m����ذ��0ؤo�8��<^�.���$�2��m� 6E�M-�e\\<~)Ƞ\l>O}GH���'X�X�eB���R灴o]�����      �   %  x���Qk�0��~�{S!H[��ؓ���t{�5�D���龰��غU�>@!�߻�4?n�ٮ�v���^�tV���X��U@n�:p֐�/��	���SMF�𷓗D�5��dJr�k�TxG�Z.�7+�[S�J�hs�Q�ju�$�t�������}��q&`��#���X���:��3�i�7!`��b�B���c� ���KF%���������.�ٻ�o��6�����/���L�\��'�'��>��Y��ѹ�����a��[x��c���ݤ�ٗ��#��oa2�6      �   D   x���v
Q���W(JMK�LN�W��L��uRR���@LM�0G�P�`3uǜ������\\\ l      �   w   x���v
Q���W(N�I�O��W��L��u����WR����'f�����E���%�)0��y)@�:
�)@��Ғ|M�0G�P�`C#=t�� ʰԴ��� �1�      �   �   x���v
Q���W(N�I�O�LT��L��uRK<0�813�N�+)J���s��sSK2S�B�y)@E�:
PSsS�Al���Ғ|M�0G�P�`Cu#] 24S�Q0�300@�`CsKMk... �<      �   z   x���v
Q���W(N�I��M-V��L��u�T 1/_�,5��(1%�+N̄���s��ZK2S`�R�R�RA� �RJK�5�}B]�4�u,��PG�@��� �24�2,5���� MN6{      �   y   x���v
Q���W(�,)MLN��,I�-HM�L�W��L��QHI-N.�
j*�9���+h��(����e&��kZsyR�dS��N���6�h�czibQJb��6휘���u4 j�y�      �   g   x���v
Q���W(�,)MLN��/JI�U��LA�QHI-N.��5�}B]�4u��R�J�5��<)3�hXPjbNfUb
5�3�眘���5�� M�M�      �   �   x��̭�0 `ߧ8�-��O��hBa�N\2Z���s�����{���f�O�LBj�_i�x�I�v���^�Pu7N9V�ָ��v6��̷���Nw�a��.��5/�m��c�<}Gc>���       �   �   x�����0�w��[!q����@b� �_Ӫ%�&X|~o!T#��,��9_����8/H�Ѽ�f�	�B���g�j���\�9G�S|$�tB(�hV�=/o�`�%�3�-�}I�͎Xs�$��C�_��r�_`���2ó�����عQ,�$��#R���SѾ��h��q��8��ʬ)�B���� ��a��:��      �   �   x���v
Q���W(I�IL�/I�W��L�st �Ts�	uV�0�Q !Mk.OJ�1�Q0��1�:
�:
F�cBc�t̨`�9�cJ�1Ɠ9���l��24�C��L��Pl�)�S��1g	��e�w��c	6��,
��%$޹� H�      �   ~   x���v
Q���W(I�IM��KU��L��uRRRt�̔������Ԕ�"�$� &�������a���nb�"����jZsy��Fs����F Ls+�����463220� ��c��\\ WSh      �   d   x���v
Q���W(�,�O�/�KMNM�/R��LA�QHI-N.�LN��Ts�	uV�0�QP)JL�L���K�Q״���L#�����E�yə� #�� !�7�      �   i   x���v
Q���W(�,�/I�IM��KU��LA��(��'e&'�k*�9���+h�(��g���%g&�kZsyRb��<����"��f2-5�4'�d �M      �   B   x���v
Q���W(�)���/-.M,��WЀ2t2SPd4�}B]�4Գ�Jr�u5���� �h      �   �   x���v
Q���W(��LILI�MM�
�)(:
y���:
��9��E��@(UX���fk*�9���+h��(�{Ä�u�s�S�TIQi��5�'�,7Z�*VG�ʡ��@�}a*A�#Y���� J�|      �   �   x���;�0��_q6 � up2ʀ1��7�
5К���Rctv`;ɹ9�r�,O�Ҭ8a�n��'�'2HQrS�Ã�M6J���;R5ght%����xIrx!C0�wO�ͨ���6��zj�;u�,���+A����7N:�)bX3�=h���+4Q ;;h!A����6'��Ewӷ��8/8��J     